/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package StudentUI;

import static Data.Controller.PopulateTable.getUserInfo;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class studentReq extends javax.swing.JPanel {

    /**
     * Creates new form adminRequest
     */
    public studentReq(String StudentID) {
        initComponents();
        fullname2.setVisible(false);
        studentid.setVisible(false);
        courseName.setVisible(false);
    }

    public static void updateStudentID(String studentID, String fullnameData) {
    studentid.setText(studentID);
        fullname2.setText(fullnameData);
        getUserInfo(fullnameData);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        courseCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        enterCourse = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        studentid = new javax.swing.JLabel();
        fullname2 = new javax.swing.JLabel();
        courseName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        courseCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCodeActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Course Code");

        enterCourse.setText("Enter");
        enterCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterCourseActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Enter Class");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fullname2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(studentid, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(enterCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(courseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fullname2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(studentid, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(courseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void enterCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterCourseActionPerformed
       String fullname = fullname2.getText().trim();
String studentID = studentid.getText().trim();
String courseCodeValue = courseCode.getText().trim();

// Validate input fields
if (fullname.isEmpty() || studentID.isEmpty() || courseCodeValue.isEmpty()) {
    JOptionPane.showMessageDialog(this, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Query to validate courseCode and retrieve courseName from the courselist table
String validationQuery = "SELECT coursename FROM courselist WHERE coursecode = ?";

// Query to check if the user is already enrolled in the course
String enrollmentCheckQuery = "SELECT COUNT(*) FROM student_to_course WHERE studentID = ? AND coursecode = ?";

// Query to check for duplicate entries
String duplicateCheckQuery = "SELECT COUNT(*) FROM studentrequestcourse WHERE studentid = ? AND coursecode = ?";

// Query to insert data into the studentrequestcourse table
String insertQuery = "INSERT INTO studentrequestcourse (fullname, studentid, coursecode, coursename, status) VALUES (?, ?, ?, ?, 'not verified')";

try {
    // Get a database connection
    Connection conn = Data.Database.DatabaseConnection.getInstance().getConnection();

    if (conn == null) {
        JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate courseCode and retrieve courseName
    try (PreparedStatement validateStmt = conn.prepareStatement(validationQuery)) {
        validateStmt.setString(1, courseCodeValue);

        try (ResultSet rs = validateStmt.executeQuery()) {
            if (rs.next()) {
                // Retrieve the courseName from the database
                String courseNameValue = rs.getString("coursename");
                courseName.setText(courseNameValue); // Display the courseName in the JLabel

                // Check if the user is already enrolled in the course
                try (PreparedStatement enrollmentCheckStmt = conn.prepareStatement(enrollmentCheckQuery)) {
                    enrollmentCheckStmt.setString(1, studentID);
                    enrollmentCheckStmt.setString(2, courseCodeValue);

                    try (ResultSet enrollmentResultSet = enrollmentCheckStmt.executeQuery()) {
                        if (enrollmentResultSet.next() && enrollmentResultSet.getInt(1) > 0) {
                            // User is already enrolled in the course
                            JOptionPane.showMessageDialog(this, "You are already enrolled in this course!", "Enrollment Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }

                // Check for duplicate entries
                try (PreparedStatement duplicateCheckStmt = conn.prepareStatement(duplicateCheckQuery)) {
                    duplicateCheckStmt.setString(1, studentID);
                    duplicateCheckStmt.setString(2, courseCodeValue);

                    try (ResultSet duplicateResultSet = duplicateCheckStmt.executeQuery()) {
                        if (duplicateResultSet.next() && duplicateResultSet.getInt(1) > 0) {
                            // Duplicate found
                            JOptionPane.showMessageDialog(this, "This course has already been requested.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }

                // Insert data into the studentrequestcourse table
                try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                    insertStmt.setString(1, fullname);
                    insertStmt.setString(2, studentID);
                    insertStmt.setString(3, courseCodeValue);
                    insertStmt.setString(4, courseNameValue);

                    int rowsInserted = insertStmt.executeUpdate();

                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Request submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        // Clear input fields
                        courseCode.setText("");
                        courseName.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to submit the request. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                // Invalid courseCode
                JOptionPane.showMessageDialog(this, "Invalid course code. Please check and try again.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}



    }//GEN-LAST:event_enterCourseActionPerformed

    private void courseCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseCodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField courseCode;
    private javax.swing.JLabel courseName;
    private javax.swing.JButton enterCourse;
    private static javax.swing.JLabel fullname2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JLabel studentid;
    // End of variables declaration//GEN-END:variables
}
