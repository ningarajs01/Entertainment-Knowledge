package com.uucms.ui;

import javax.swing.*;
import java.awt.*;

public class StudentDashbord extends JFrame {
    public StudentDashbord(String studentName) {
        setTitle("UUCMS - Student Portal (" + studentName + ")");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(39, 174, 96)); // Green for Student
        JLabel lbl = new JLabel("Welcome, " + studentName);
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        header.add(lbl);
        add(header, BorderLayout.NORTH);

        // Student Menu
        JPanel menu = new JPanel(new GridLayout(4, 1, 10, 10));
        menu.setPreferredSize(new Dimension(180, 0));
        
        JButton btnProfile = new JButton("My Profile");
        JButton btnMyFee = new JButton("My Fee Status");
        JButton btnMyResult = new JButton("My Results");
        JButton btnLogout = new JButton("Logout");

        menu.add(btnProfile);
        menu.add(btnMyFee);
        menu.add(btnMyResult);
        menu.add(btnLogout);
        add(menu, BorderLayout.WEST);

        // Action Listeners
        btnMyFee.addActionListener(e -> new ViewFeeFrame().setVisible(true));
        btnMyResult.addActionListener(e -> new ViewResultFrame().setVisible(true));
        btnLogout.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            this.dispose();
        });

        // Center Area
        JPanel main = new JPanel();
        main.add(new JLabel("Welcome to your Portal. Check your academic status from the left."));
        add(main, BorderLayout.CENTER);
    }
}