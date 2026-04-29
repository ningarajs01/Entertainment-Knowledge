package com.uucms.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.uucms.dao.StudentDAO; // Database logic ko call karne ke liye

public class ManageStudentFrame extends JFrame {
    // Input Fields
    private JTextField txtId, txtName, txtCourse;
    private JButton btnSave, btnBack;

    public ManageStudentFrame() {
        // Window Configuration
        setTitle("UUCMS - Manage Students (Raj Special)");
        setSize(400, 350);
        setLayout(null); // Manual layout for precision
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(236, 240, 241));

        // 1. Heading
        JLabel lblTitle = new JLabel("Add New Student", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(100, 20, 200, 30);
        add(lblTitle);

        // 2. ID Field
        JLabel lblId = new JLabel("Student ID:");
        lblId.setBounds(50, 70, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(160, 70, 150, 25);
        add(txtId);

        // 3. Name Field
        JLabel lblName = new JLabel("Full Name:");
        lblName.setBounds(50, 110, 100, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(160, 110, 150, 25);
        add(txtName);

        // 4. Course Field
        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(50, 150, 100, 25);
        add(lblCourse);

        txtCourse = new JTextField();
        txtCourse.setBounds(160, 150, 150, 25);
        add(txtCourse);

        // 5. Save Button
        btnSave = new JButton("Save Student");
        btnSave.setBounds(60, 210, 120, 35);
        btnSave.setBackground(new Color(46, 204, 113));
        btnSave.setForeground(Color.WHITE);
        add(btnSave);

        // 6. Back Button
        btnBack = new JButton("Back");
        btnBack.setBounds(200, 210, 100, 35);
        add(btnBack);

        // --- Event Handling ---

        // Save Button Logic
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText().trim());
                    String name = txtName.getText().trim();
                    String course = txtCourse.getText().trim();

                    if(name.isEmpty() || course.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Sab fields bharo re baba!");
                        return;
                    }

                    StudentDAO dao = new StudentDAO();
                    if(dao.addStudent(id, name, course)) {
                        JOptionPane.showMessageDialog(null, "Mubarak ho! Student add ho gaya. ✅");
                        // Clear fields after save
                        txtId.setText("");
                        txtName.setText("");
                        txtCourse.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Database Error! 'Daya, kuch toh gadbad hai'");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID mein sirf number dalo!");
                }
            }
        });

        // Back Button Logic
        btnBack.addActionListener(e -> {
            dispose(); // Sirf ye window band hogi
        });
    }

    public static void main(String[] args) {
        new ManageStudentFrame().setVisible(true);
    }
}