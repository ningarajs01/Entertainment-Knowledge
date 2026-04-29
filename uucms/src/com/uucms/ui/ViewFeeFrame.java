package com.uucms.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import com.uucms.config.DBConnection;

public class ViewFeeFrame extends JFrame {
    public ViewFeeFrame() {
        setTitle("Fee Details - Raj Panel");
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] columns = {"ID", "Total Fee", "Paid", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM fees");
            while(rs.next()) {
                model.addRow(new Object[]{rs.getInt("id"), rs.getInt("total_fee"), rs.getInt("paid_fee"), rs.getInt("balance")});
            }
        } catch (Exception e) { e.printStackTrace(); }

        add(new JScrollPane(table));
    }
}