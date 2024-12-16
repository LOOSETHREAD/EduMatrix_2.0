/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Login;

import Data.Controller.UserController;
import Data.Models.ModelStudentUser;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class StudentRegister extends javax.swing.JPanel {

    /**
     * Creates new form StudentRegister
     */
        public ModelStudentUser getUser() {
        return user;
    }
    private ModelStudentUser user;
    public StudentRegister() {
        initComponents();
    }
    public void addEventStudentRegister(ActionListener event) {
        cmdBackLogin.addActionListener(event);
    }
    public void addEventBackLogin(ActionListener event) {
        cmdBackLogin.addActionListener(event);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmdBackLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        registerBttn = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        fullName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        programField = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(41, 78, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        cmdBackLogin.setForeground(new java.awt.Color(255, 255, 255));
        cmdBackLogin.setText("Login Here");
        cmdBackLogin.setBorderPainted(false);
        cmdBackLogin.setContentAreaFilled(false);
        cmdBackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBackLoginActionPerformed(evt);
            }
        });
        jPanel1.add(cmdBackLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 100, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Already have an account yet?");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 45)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Welcome!");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 37, -1, -1));
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 240, 32));

        registerBttn.setText("Sign Up");
        registerBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBttnActionPerformed(evt);
            }
        });
        jPanel1.add(registerBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 88, 29));
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 240, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fullname");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        fullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameActionPerformed(evt);
            }
        });
        jPanel1.add(fullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 240, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Program");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        programField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programFieldActionPerformed(evt);
            }
        });
        jPanel1.add(programField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 240, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdBackLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBackLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdBackLoginActionPerformed

    private void registerBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBttnActionPerformed
        // TODO add your handling code here:
       String fullname = fullName.getText();
String program = programField.getText();
String username = txtUser.getText();
char[] password = txtPass.getPassword();

// Generate a unique student ID
UserController controller = new UserController();
String studentid = controller.generateStudentId();

ModelStudentUser user = new ModelStudentUser(fullname, program, username, password, studentid);

// Register the user
try {
    controller.registerStudentUser(user);
    JOptionPane.showMessageDialog(this, "User Added Successfully with ID: " + studentid);
} catch (ClassNotFoundException ex) {
    Logger.getLogger(StudentRegister.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(this, "Failed to add user. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
}


    }//GEN-LAST:event_registerBttnActionPerformed

    private void fullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullNameActionPerformed

    private void programFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBackLogin;
    private javax.swing.JTextField fullName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField programField;
    private javax.swing.JButton registerBttn;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
