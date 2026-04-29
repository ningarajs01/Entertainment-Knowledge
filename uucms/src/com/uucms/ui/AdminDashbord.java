package com.uucms.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashbord extends JFrame {
    
    public AdminDashbord() {
        // 1. Window Settings
        setTitle("UUCMS - Admin Dashboard (Raj)");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        // 2. Top Panel (Header)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(41, 128, 185)); 
        headerPanel.setPreferredSize(new Dimension(0, 60));
        JLabel lblWelcome = new JLabel("Welcome to UUCMS Portal - Admin Panel");
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 22));
        headerPanel.add(lblWelcome);
        add(headerPanel, BorderLayout.NORTH);

        // 3. Side Panel (Menu)
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(6, 1, 10, 10)); 
        sidePanel.setPreferredSize(new Dimension(220, 0));
        sidePanel.setBackground(new Color(52, 73, 94));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        // Individual Buttons
        JButton btnManage = new JButton("Manage Students");
        JButton btnAttendance = new JButton("View Attendance");
        JButton btnFee = new JButton("Fee Details");
        JButton btnResults = new JButton("Exam Results");
        JButton btnLogout = new JButton("Logout");

        JButton[] allButtons = {btnManage, btnAttendance, btnFee, btnResults, btnLogout};
        for (JButton b : allButtons) {
            b.setFocusable(false);
            b.setFont(new Font("Arial", Font.PLAIN, 14));
        }

        // --- SABHI BUTTONS KA LOGIC YAHAN HAI ---

        // 1. Manage Students
        btnManage.addActionListener(e -> {
            new ManageStudentFrame().setVisible(true); 
        });

        // 2. View Attendance
        btnAttendance.addActionListener(e -> {
            new ViewAttendanceFrame().setVisible(true); // Isse wo table khulegi
        });

        // 3. Fee Details
        btnFee.addActionListener(e -> {
            // Agar file nahi banayi toh red error aayega
            new ViewFeeFrame().setVisible(true); 
        });

        // 4. Exam Results
        btnResults.addActionListener(e -> {
            new ViewResultFrame().setVisible(true); 
        });

        // 5. Logout
        btnLogout.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this, "Sach mein ja rahe ho?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                new LoginFrame().setVisible(true);
                this.dispose();
            }
        });

        // Buttons ko Panel mein daalo
        sidePanel.add(btnManage);
        sidePanel.add(btnAttendance);
        sidePanel.add(btnFee);
        sidePanel.add(btnResults);
        sidePanel.add(new JLabel("")); 
        sidePanel.add(btnLogout);

        add(sidePanel, BorderLayout.WEST);

        // 4. Center Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new GridBagLayout()); 
        JLabel lblMain = new JLabel("<html><div style='text-align: center;'>Welcome Raj!<br>Select an option from the left to begin.</div></html>");
        lblMain.setFont(new Font("Serif", Font.ITALIC, 24));
        lblMain.setForeground(Color.GRAY);
        mainPanel.add(lblMain);
        
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        new AdminDashbord().setVisible(true);
    }
}