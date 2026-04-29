package com.uucms.config;

import java.sql.Connection;
import java.sql.DriverManager;
import com.uucms.dao.UserDAO; // DAO ko import karna mat bhulna

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            // Oracle driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "system";
            String pass = "2003";

            con = DriverManager.getConnection(url, user, pass);
            // System.out.println("Connected to database"); // Optional: Testing ke liye theek hai
        } catch (Exception e) {
            System.out.println("Not connected DataBase");
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        // 1. Pehle Connection check karo
        Connection con = getConnection();

        if (con != null) {
            System.out.println("Step 1: Database Connected! ✅");

            // 2. Ab UserDAO ka object banao
            UserDAO dao = new UserDAO();

            // 3. Login check karo (Raj aur 2003 match karega ab!)
            String role = dao.checkLogin("raj", "2003");

            if (role != null) {
                System.out.println("Step 2: Login Working! User Role is: " + role + " 🎯");
            } else {
                System.out.println("Step 2: Login Failed! Check username/password in DB. ❌");
            }
        } else {
            System.out.println("Step 1: Connection Failed! ❌");
        }
    }
}