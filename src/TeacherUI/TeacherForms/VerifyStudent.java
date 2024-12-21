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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
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
        centerDataTable();
        
    }
    private void centerDataTable(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i <studentReqTable.getColumnModel().getColumnCount(); i++) {
            studentReqTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Center the header text
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) studentReqTable.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        studentReqTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        fullName = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        courseCode = new javax.swing.JLabel();
        courseName = new javax.swing.JLabel();
        studentid = new javax.swing.JLabel();
        spr = new javax.swing.JLabel();
        statusspr = new javax.swing.JLabel();
        quizName = new javax.swing.JLabel();
        pictureBox1 = new Swing.PictureBox();
        pictureBox2 = new Swing.PictureBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 78, 89), 6));
        setPreferredSize(new java.awt.Dimension(640, 381));

        studentReqTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        fullName.setBackground(new java.awt.Color(255, 255, 255));
        fullName.setOpaque(true);

        statusLabel.setBackground(new java.awt.Color(255, 255, 255));
        statusLabel.setOpaque(true);

        courseCode.setBackground(new java.awt.Color(255, 255, 255));
        courseCode.setOpaque(true);

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-close-48.png"))); // NOI18N
        pictureBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox1MouseClicked(evt);
            }
        });

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-checkmark-48.png"))); // NOI18N
        pictureBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox2MouseClicked(evt);
            }
        });

        jLabel1.setText("Confirm");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("Decline");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(fullName)
                                .addGap(37, 37, 37)
                                .addComponent(courseCode)
                                .addGap(461, 461, 461)
                                .addComponent(statusLabel))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)))
                        .addGap(66, 66, 66)
                        .addComponent(courseName)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(spr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusspr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(studentid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quizName)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(studentid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quizName)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pictureBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(fullName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spr))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(statusspr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(courseName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusLabel)
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
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
    }//GEN-LAST:event_jLabel1MouseClicked

    private void pictureBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseClicked
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
    }//GEN-LAST:event_pictureBox2MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
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
    }//GEN-LAST:event_jLabel2MouseClicked

    private void pictureBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseClicked
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
    }//GEN-LAST:event_pictureBox1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseCode;
    private javax.swing.JLabel courseName;
    private javax.swing.JLabel fullName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private Swing.PictureBox pictureBox1;
    private Swing.PictureBox pictureBox2;
    private javax.swing.JLabel quizName;
    private javax.swing.JLabel spr;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel statusspr;
    private javax.swing.JTable studentReqTable;
    private javax.swing.JLabel studentid;
    // End of variables declaration//GEN-END:variables
}
