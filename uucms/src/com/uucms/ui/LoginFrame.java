package com.uucms.ui;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.uucms.config.DBConnection; 

public class LoginFrame extends JFrame {
    JTextField userText;
    JPasswordField passText;
    JButton loginButton;

    public LoginFrame() {
        setTitle("UUCMS Login - Raj Special");
        setSize(350, 240); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); 

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 25);
        add(userLabel);

        userText = new JTextField();
        userText.setBounds(120, 20, 150, 25);
        add(userText);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 50, 80, 25);
        add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(120, 50, 150, 25);
        add(passText);

        loginButton = new JButton("Login");
        loginButton.setBounds(120, 100, 100, 30); 
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkLogin();
            }
        });
    }

    private void checkLogin() {
        String user = userText.getText().trim();
        String pass = new String(passText.getPassword()).trim();

        // Debugging ke liye (Terminal pe dikhega ki Java kya bhej raha hai)
        System.out.println("Attempting login: [" + user + "] with password: [" + pass + "]");

        try {
            Connection con = DBConnection.getConnection();
            // CHANCE 1: Kabhi-kabhi SQL mein TRIM(column) index ko slow kar deta hai,
            // isliye simple query use karke data fetch karne ke baad check karna zyada safe hai.
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // CHANCE 2: DB se aane wale data mein bhi spaces ho sakti hain, use trim() karo
                String role = rs.getString("role") != null ? rs.getString("role").trim() : "";
                String name = rs.getString("username").trim();

                JOptionPane.showMessageDialog(this, "Login Successful! Welcome " + name);
                
                if (role.equalsIgnoreCase("admin")) {
                    new AdminDashbord().setVisible(true);
                } else {
                    new StudentDashbord(name).setVisible(true);
                }
                
                this.dispose(); 
                
            } else {
                // Agar yahan aa raha hai, matlab SQL ko match nahi mila
                JOptionPane.showMessageDialog(this, "Invalid Username/Password! 'Tumse na ho payega'");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Database Connection Error!");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        
        new LoginFrame().setVisible(true);
    }
}