/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Connection.ConnectionManager;
import Entity.Recordlog;
import Entity.Staff;
import Entity.Suster;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 48faraaz
 */
public class ExecuteStaff {
    public List<Staff> getAllStaff() {
        List<Staff> listS = new ArrayList<>();
        String query = "SELECT * FROM staff";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                Staff s = new Staff();
                s.setKtp(rs.getString("ktp"));
                s.setNama(rs.getString("nama"));
                s.setAlamat(rs.getString("alamat"));
                s.setHp(rs.getString("hp"));
                s.setKelamin(rs.getString("kelamin"));
                listS.add(s);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return listS;
    }
    
    public int insertStaff(Staff ps) {
        int hasil = 0;
        String query = "INSERT INTO staff(ktp, password, nama, alamat, hp, kelamin) VALUES('"+ps.getKtp()+"', '"+ps.getKtp()+"', '"+ps.getNama()+"', '"+ps.getAlamat()+"', '"+ps.getHp()+"', '"+ps.getKelamin()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int deleteStaff(String id) {
        int hasil = 0;
        String query = "DELETE FROM staff WHERE ktp='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public int updateStaff(Staff ps) {
        int hasil = 0;
        String query = "UPDATE staff SET ktp='"+ps.getKtp()+"', nama='"+ps.getNama()+"', alamat='"+ps.getAlamat()+"', hp='"+ps.getHp()+"', kelamin='"+ps.getKelamin()+"' WHERE ktp='"+ps.getKtp()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return hasil;
    }
    
    public Staff getRow(String ktp) {
        Staff staff = new Staff();
        String query = "SELECT * FROM staff WHERE ktp='"+ktp+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.LogOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()) {
                staff.setKtp(rs.getString("ktp"));
                staff.setNama(rs.getString("nama"));
                staff.setHp(rs.getString("hp"));
                staff.setAlamat(rs.getString("alamat"));
                staff.setKelamin(rs.getString("kelamin"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ExecuteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.LogOff();
        return staff;
    }
}
