package com.uucms.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import com.uucms.config.DBConnection;

public class ViewResultFrame extends JFrame {
    public ViewResultFrame() {
        setTitle("Exam Results - Raj Panel");
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] columns = {"ID", "Subject", "Marks", "Grade"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM results");
            while(rs.next()) {
                model.addRow(new Object[]{rs.getInt("id"), rs.getString("subject"), rs.getInt("marks"), rs.getString("grade")});
            }
        } catch (Exception e) { e.printStackTrace(); }

        add(new JScrollPane(table));
    }
}
