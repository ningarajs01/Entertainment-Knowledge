package com.uucms.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import com.uucms.dao.StudentDAO;

public class ViewAttendanceFrame extends JFrame {
    public ViewAttendanceFrame() {
        setTitle("Student Attendance/List - Raj Panel");
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Table Columns
        String[] columns = {"ID", "Name", "Course"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        // Data fetch karo
        try {
            StudentDAO dao = new StudentDAO();
            ResultSet rs = dao.getAllStudents();
            while(rs.next()) {
                model.addRow(new Object[]{rs.getInt("id"), rs.getString("name"), rs.getString("course")});
            }
        } catch (Exception e) { e.printStackTrace(); }

        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}