package com.uucms.dao;

import java.sql.*;
import com.uucms.config.DBConnection;

public class StudentDAO {
    
    // 1. Pehle se jo 'Add' wala method hai (Yahan khatam ho raha hai)
    public boolean addStudent(int id, String name, String course) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO students VALUES(?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, course);
            
            int result = pst.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 2. AB YAHAN YE NAYA WALA PASTE KAR DO (View ke liye)
    public ResultSet getAllStudents() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM students";
            Statement st = con.createStatement();
            return st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("Error fetching data!");
            e.printStackTrace();
            return null;
        }
    }
} // Yeh aakhri bracket class ka hai, isse mat hatana!