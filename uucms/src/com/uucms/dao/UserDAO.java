package com.uucms.dao;

import java.sql.*;

import com.uucms.config.DBConnection;

public class UserDAO {
    public String checkLogin(String username, String password) {
        // Query fix: users (not uesrs) aur username (not usrname)
        String query = "SELECT role FROM users WHERE username=? AND password=?";
        
        try (Connection con = DBConnection.getConnection()) {
            if (con == null) return null; // Connection hi nahi hua toh exit

            PreparedStatement pst = con.prepareStatement(query); // Ye line MUST hai
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString("role"); // User mil gaya!
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Login fail
    }
}