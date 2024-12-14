/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TeacherUI.TeacherForms;

import TeacherUI.TeacherForms.AddQuiz;
import Data.Controller.PopulateTable;
import Data.Database.DatabaseConnection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *
 * @author User
 */
public class VerifyStudent extends javax.swing.JPanel {
    private AddQuiz addQuizPanel;
    private DefaultTableModel studentReqTableModel;
    public VerifyStudent(AddQuiz addQuizPanel) {
        this.addQuizPanel = addQuizPanel;
        initComponents();
        fullName.setVisible(false);
        courseCode.setVisible(false);
        statusLabel.setVisible(false);
        courseName.setVisible(false);
        studentid.setVisible(false);
        studentReqTableModel = (DefaultTableModel) studentReqTable.getModel();
        PopulateTable.populateStudentRequestTable(studentReqTable);
        
    }
    public void TextFieldEmpty(){
        fullName.setText("");
        courseCode.setText("");
        statusLabel.setText("");
        courseName.setText("");
        studentid.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentReqTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        confirmBtn = new javax.swing.JButton();
        fullName = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        courseCode = new javax.swing.JLabel();
        declineBtn = new javax.swing.JButton();
        courseName = new javax.swing.JLabel();
        studentid = new javax.swing.JLabel();
        spr = new javax.swing.JLabel();
        statusspr = new javax.swing.JLabel();
        quizName = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        studentReqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Full Name", "Student ID", "Course Code", "Course Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentReqTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentReqTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentReqTable);
        if (studentReqTable.getColumnModel().getColumnCount() > 0) {
            studentReqTable.getColumnModel().getColumn(0).setResizable(false);
            studentReqTable.getColumnModel().getColumn(1).setMinWidth(0);
            studentReqTable.getColumnModel().getColumn(1).setPreferredWidth(0);
            studentReqTable.getColumnModel().getColumn(1).setMaxWidth(0);
            studentReqTable.getColumnModel().getColumn(2).setResizable(false);
            studentReqTable.getColumnModel().getColumn(3).setResizable(false);
            studentReqTable.getColumnModel().getColumn(4).setResizable(false);
        }

        confirmBtn.setText("Confirm");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        fullName.setBackground(new java.awt.Color(255, 255, 255));
        fullName.setOpaque(true);

        statusLabel.setBackground(new java.awt.Color(255, 255, 255));
        statusLabel.setOpaque(true);

        courseCode.setBackground(new java.awt.Color(255, 255, 255));
        courseCode.setOpaque(true);

        declineBtn.setText("Decline");
        declineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(declineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(statusspr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(quizName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(studentid, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(courseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentid, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spr, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                            .addComponent(statusspr, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                            .addComponent(quizName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(declineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void studentReqTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentReqTableMouseClicked
        // TODO add your handling code here:
        int selectIndex = studentReqTable.getSelectedRow();
        fullName.setText(studentReqTableModel.getValueAt(selectIndex, 0).toString());
        studentid.setText(studentReqTableModel.getValueAt(selectIndex, 1).toString());
        courseCode.setText(studentReqTableModel.getValueAt(selectIndex, 2).toString());
        courseName.setText(studentReqTableModel.getValueAt(selectIndex,3).toString());
        statusLabel.setText(studentReqTableModel.getValueAt(selectIndex, 4).toString());
    }//GEN-LAST:event_studentReqTableMouseClicked

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = studentReqTable.getSelectedRow(); 
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Please select a student to confirm.", "No Selection", JOptionPane.WARNING_MESSAGE);
    return;
}

try {
    // Extract student details from the selected row
    String fullName = studentReqTableModel.getValueAt(selectedRow, 0).toString();
    String studentID = studentReqTableModel.getValueAt(selectedRow, 1).toString();
    String courseCode = studentReqTableModel.getValueAt(selectedRow, 2).toString();
    String courseName = studentReqTableModel.getValueAt(selectedRow, 3).toString();
    String studSpr = spr.getText();
    String sprstatus = statusspr.getText();

    // SQL queries
    String insertSQL = "INSERT INTO student_to_course (coursecode, coursename, student_name, studentID, status, spr, statusspr) VALUES (?, ?, ?, ?, 'verified', ?, ?)";
//    String insertSQL2 = "INSERT INTO quizes (coursecode, coursename, studentid, fullname, quiznumber, quizresult, quiztotal, status) VALUES (?, ?, ?, ?, '', '', '', '')";
    String deleteSQL = "DELETE FROM studentrequestcourse WHERE coursecode = ? AND coursename = ? AND studentID = ? AND fullname = ?";

    // Use the singleton instance of DatabaseConnection
    DatabaseConnection dbConnection = DatabaseConnection.getInstance();

    // Execute the insert and delete in a single transaction
    try (Connection conn = dbConnection.getConnection()) {
        conn.setAutoCommit(false); // Start transaction

        try (
            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
//            PreparedStatement insertStmt2 = conn.prepareStatement(insertSQL2);
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)
        ) {
            // Insert into the verified table
            insertStmt.setString(1, courseCode);
            insertStmt.setString(2, courseName);
            insertStmt.setString(3, fullName);
            insertStmt.setString(4, studentID);
            insertStmt.setString(5, studSpr);
            insertStmt.setString(6, sprstatus);
            int rowsInserted = insertStmt.executeUpdate();

            if (rowsInserted > 0) {
                // Insert into the quizzes table
//                insertStmt2.setString(1, courseCode);
//                insertStmt2.setString(2, courseName);
//                insertStmt2.setString(3, studentID);
//                insertStmt2.setString(4, fullName);
//                int quizInserted = insertStmt2.executeUpdate();
//
//                if (quizInserted > 0) {
                    // Remove from the request table
                    deleteStmt.setString(1, courseCode);
                    deleteStmt.setString(2, courseName);
                    deleteStmt.setString(3, studentID);
                    deleteStmt.setString(4, fullName);
                    int rowsDeleted = deleteStmt.executeUpdate();

                    if (rowsDeleted > 0) {
                        conn.commit(); // Commit the transaction

                        // Update the UI
                        studentReqTableModel.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(this, "Student has been verified successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        conn.rollback(); // Rollback if deletion fails
                        JOptionPane.showMessageDialog(this, "Failed to remove the request from the database. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
//                } else {
//                    conn.rollback(); // Rollback if quiz insertion fails
//                    JOptionPane.showMessageDialog(this, "Failed to insert quiz data. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
//                }
            } else {
                conn.rollback(); // Rollback if verified table insertion fails
                JOptionPane.showMessageDialog(this, "Failed to verify the student. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            conn.rollback(); // Rollback the transaction in case of error
            throw e;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
} catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "An error occurred while verifying the student.", "Error", JOptionPane.ERROR_MESSAGE);
}

// Clear any input fields if necessary
TextFieldEmpty();

// Repopulate the request table
PopulateTable.populateStudentRequestTable(studentReqTable);


    }//GEN-LAST:event_confirmBtnActionPerformed

    private void declineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = studentReqTable.getSelectedRow();
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Please select a student request to decline.", "No Selection", JOptionPane.WARNING_MESSAGE);
    return;
}

// Extract student details from the selected row
String fullName = studentReqTableModel.getValueAt(selectedRow, 0).toString();
String studentID = studentReqTableModel.getValueAt(selectedRow, 1).toString();
String courseCode = studentReqTableModel.getValueAt(selectedRow, 2).toString();
String courseName = studentReqTableModel.getValueAt(selectedRow, 3).toString();

try {
    // SQL query to delete the student request from the database
    String sql = "DELETE FROM studentrequestcourse WHERE fullname = ? AND studentid = ? AND coursecode = ? AND coursename = ?";

    // Use the singleton instance of DatabaseConnection
    DatabaseConnection dbConnection = DatabaseConnection.getInstance();
    try (PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(sql)) {
        // Set parameters for the query
        pstmt.setString(1, fullName);
        pstmt.setString(2, studentID);
        pstmt.setString(3, courseCode);
        pstmt.setString(4, courseName);

        // Execute the delete operation
        int rowsDeleted = pstmt.executeUpdate();

        if (rowsDeleted > 0) {
            // Update the UI to remove the row
            studentReqTableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Student request has been declined and removed.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to decline the student request. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Optionally clear input fields
        TextFieldEmpty();
    }
} catch (Exception ex) {
    // Log the exception and notify the user
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "An error occurred while declining the student request.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        PopulateTable.populateStudentRequestTable(studentReqTable);
    }//GEN-LAST:event_declineBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel courseCode;
    private javax.swing.JLabel courseName;
    private javax.swing.JButton declineBtn;
    private javax.swing.JLabel fullName;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quizName;
    private javax.swing.JLabel spr;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel statusspr;
    private javax.swing.JTable studentReqTable;
    private javax.swing.JLabel studentid;
    // End of variables declaration//GEN-END:variables
}