package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LogInForm extends javax.swing.JFrame {

    public LogInForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usernameLable = new javax.swing.JLabel();
        passwordLable = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        passwordCheckBox = new javax.swing.JCheckBox();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        usernameLable.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        usernameLable.setText("Username: ");
        usernameLable.setToolTipText("");

        passwordLable.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        passwordLable.setText("Password:");

        usernameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        passwordCheckBox.setText("Show Password");
        passwordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordCheckBoxActionPerformed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        loginButton.setText("LogIn");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(passwordCheckBox))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(205, 205, 205))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(passwordLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(usernameLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLable)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLable)
                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(passwordCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
           
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/log-in_form", "root", "root"); PreparedStatement preparedStatement = connection.prepareStatement("select * from users where userName = ? and userPassword = ?;")) {     
            preparedStatement.setString(1, usernameField.getText());
            preparedStatement.setString(2, String.valueOf(passwordField.getPassword()));
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                if(resultSet.getString(4).equals("administrator")){
                    if (resultSet.getString(5).equalsIgnoreCase("1")) {
                        JOptionPane.showMessageDialog(null, "Log In like Administrator!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Activate your account!");
                    }
                }if(resultSet.getString(4).equals("moderator")){
                    if (resultSet.getString(5).equalsIgnoreCase("1")) {
                        JOptionPane.showMessageDialog(null, "Log In like Moderator!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Activate your account!");
                    }                   
                }if(resultSet.getString(4).equals("user")){
                    if (resultSet.getString(5).equalsIgnoreCase("1")) {
                        JOptionPane.showMessageDialog(null, "Log In like User!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Activate your account!");
                    }                  
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid username or password!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void passwordCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordCheckBoxActionPerformed
        if(passwordCheckBox.isSelected()){
            passwordField.setEchoChar((char)0);
        }else{
            passwordField.setEchoChar('*');
        }
    }//GEN-LAST:event_passwordCheckBoxActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JCheckBox passwordCheckBox;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLable;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLable;
    // End of variables declaration//GEN-END:variables
}
