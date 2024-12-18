/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TeacherUI.TeacherForms;

import Data.Controller.AddData;
import static Data.Controller.PopulateTable.populateStudentToCourseTable;
import Data.Models.ModelStudentToCourse;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class CourseInfo extends javax.swing.JPanel {

   private AddData datacontroller;
    private DefaultTableModel studentDataTableModel;
    public CourseInfo() {
        initComponents();
        statusField.setVisible(false);
        courseCode.setVisible(false);
        courseName.setVisible(false);;
        fullName.setVisible(false);
        studentID.setVisible(false);
        studstatus.setVisible(false);
        courseCode.setVisible(false);
        idcourselist.setVisible(false);
        datacontroller = new AddData(studentDataTableModel);
    }
    public void updateBtn() {
    int idData = Integer.parseInt(idcourselist.getText());
    String courseCodeToUpdate = courseCode.getText();
        ModelStudentToCourse updatedData = new ModelStudentToCourse( courseName.getText(), courseCodeToUpdate, fullName.getText(), studentID.getText(),studstatus.getText(),gradeField.getText(),statusField.getText());
    // Update the course in the database
    datacontroller.updateStudentTOCourse(updatedData, idData);
    
    // Update the table
    populateStudentToCourseTable(studentDataTable, courseCodeToUpdate);
    TextFieldEmpty();
}
    public void TextFieldEmpty(){
        courseCode.setText("");
        courseName.setText("");
        fullName.setText("");
        studentID.setText("");
        studstatus.setText("");
        idcourselist.setText("");
        gradeField.setText("");
        statusField.setText("");
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
        studentDataTable = new javax.swing.JTable();
        gradeField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        statusField = new javax.swing.JLabel();
        courseCode = new javax.swing.JLabel();
        courseName = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        fullName = new javax.swing.JLabel();
        studentID = new javax.swing.JLabel();
        idcourselist = new javax.swing.JLabel();
        studstatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 78, 89), 2));

        studentDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Course Code", "Course Name", "Student ID", "Student Name", "StudentStats", "idcourse", "Grade", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentDataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentDataTable);
        if (studentDataTable.getColumnModel().getColumnCount() > 0) {
            studentDataTable.getColumnModel().getColumn(0).setResizable(false);
            studentDataTable.getColumnModel().getColumn(1).setResizable(false);
            studentDataTable.getColumnModel().getColumn(2).setResizable(false);
            studentDataTable.getColumnModel().getColumn(3).setResizable(false);
            studentDataTable.getColumnModel().getColumn(4).setMinWidth(0);
            studentDataTable.getColumnModel().getColumn(4).setPreferredWidth(0);
            studentDataTable.getColumnModel().getColumn(4).setMaxWidth(0);
            studentDataTable.getColumnModel().getColumn(5).setMinWidth(0);
            studentDataTable.getColumnModel().getColumn(5).setPreferredWidth(0);
            studentDataTable.getColumnModel().getColumn(5).setMaxWidth(0);
            studentDataTable.getColumnModel().getColumn(6).setResizable(false);
            studentDataTable.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel1.setText("Add Grade");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(gradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(studentID, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idcourselist, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(studstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(studentID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(studstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(idcourselist, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(statusField, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (courseCode.getText().trim().isEmpty() || 
        courseName.getText().trim().isEmpty() || 
        fullName.getText().trim().isEmpty() || 
        studentID.getText().trim().isEmpty()) {
        
        // If any of these fields are empty, show a message and exit the method
        JOptionPane.showMessageDialog(this, "Please select a student's data", 
                                      "Input Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method if any field is empty
    }
        double grade = 0;
    try {
        // Try to parse the value from the quizResult field
        grade = Double.parseDouble(gradeField.getText().trim());
    } catch (NumberFormatException e) {
        // Handle invalid number input
        JOptionPane.showMessageDialog(this, "Please enter a valid grade.", 
                                      "Input Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit method if the input is invalid
    }

    // Check if the grade is below 75 and set the statusField
    if (grade < 75) {
        statusField.setText("Failed");
    } else {
        statusField.setText("Passed");
    }
        updateBtn();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void studentDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentDataTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) studentDataTable.getModel();
        int selectIndex = studentDataTable.getSelectedRow();
        courseCode.setText(model.getValueAt(selectIndex, 0).toString());
        courseName.setText(model.getValueAt(selectIndex, 1).toString());
         studentID.setText(model.getValueAt(selectIndex , 2).toString());
         fullName.setText(model.getValueAt(selectIndex , 3).toString());
         studstatus.setText(model.getValueAt(selectIndex , 4).toString());
         gradeField.setText(model.getValueAt(selectIndex, 6).toString());
         statusField.setText(model.getValueAt(selectIndex, 7).toString());
         idcourselist.setText(model.getValueAt(selectIndex , 5).toString());
    }//GEN-LAST:event_studentDataTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseCode;
    private javax.swing.JLabel courseName;
    private javax.swing.JLabel fullName;
    private javax.swing.JTextField gradeField;
    private javax.swing.JLabel idcourselist;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel statusField;
    public static javax.swing.JTable studentDataTable;
    private javax.swing.JLabel studentID;
    private javax.swing.JLabel studstatus;
    // End of variables declaration//GEN-END:variables
}
