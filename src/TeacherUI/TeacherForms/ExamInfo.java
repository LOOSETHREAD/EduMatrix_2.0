/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TeacherUI.TeacherForms;

import Data.Controller.AddData;
import static Data.Controller.PopulateTable.PopulateStudentInfoToExamTable;
import Data.Models.ModelExam;
import static TeacherUI.TeacherForms.QuizInfo.quizTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ExamInfo extends javax.swing.JPanel {

    private AddData datacontroller;
    private DefaultTableModel examDataTableModel;
    public ExamInfo() {
        initComponents();
        statusField.setVisible(false);
        examNo.setVisible(false);
        courseCode.setVisible(false);
        courseName.setVisible(false);
        studentName.setVisible(false);
        studentId.setVisible(false);
        id.setVisible(false);
        datacontroller = new AddData(examDataTableModel);
    }
    public void TextFieldEmpty(){
        courseCode.setText("");
        courseName.setText("");
        studentName.setText("");
        studentId.setText("");
        examNo.setText("");
        examResult.setText("");
        examTotal.setText("");
        statusField.setText("");
        id.setText("");
    }
    public void updateBtn() {
    int idData = Integer.parseInt(id.getText());
    String courseCodeToUpdate = courseCode.getText();
    String examName = examNo.getText();
        ModelExam updatedData = new ModelExam(courseCodeToUpdate, courseName.getText(), studentId.getText(), studentName.getText(), examName, examResult.getText(),examTotal.getText(), statusField.getText());
    // Update the course in the database
    datacontroller.updateStudentExamToDatabase(updatedData, idData);
    
    // Update the table
    
    PopulateStudentInfoToExamTable(ExamInfo.examTable,examName, courseCodeToUpdate);
    TextFieldEmpty();
}
    private boolean validateFields() {
    if (examResult.getText().trim().isEmpty() || examTotal.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter values for both Exam Result and Exam Total.", 
                                      "Input Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    try {
        // Try parsing values to ensure they are numbers
        Double.parseDouble(examResult.getText().trim());
        Double.parseDouble(examTotal.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers in the fields.", 
                                      "Input Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
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
        examTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        examResult = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        examTotal = new javax.swing.JTextField();
        statusField = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        courseCode = new javax.swing.JLabel();
        courseName = new javax.swing.JLabel();
        studentId = new javax.swing.JLabel();
        studentName = new javax.swing.JLabel();
        examNo = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        examTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Course Code", "Course Name", "Student ID", "Student Name", "Exam Name", "Exam Result", "Exam Total", "Status", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        examTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                examTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(examTable);
        if (examTable.getColumnModel().getColumnCount() > 0) {
            examTable.getColumnModel().getColumn(0).setResizable(false);
            examTable.getColumnModel().getColumn(1).setResizable(false);
            examTable.getColumnModel().getColumn(2).setResizable(false);
            examTable.getColumnModel().getColumn(3).setResizable(false);
            examTable.getColumnModel().getColumn(4).setResizable(false);
            examTable.getColumnModel().getColumn(5).setResizable(false);
            examTable.getColumnModel().getColumn(6).setResizable(false);
            examTable.getColumnModel().getColumn(7).setResizable(false);
            examTable.getColumnModel().getColumn(8).setMinWidth(0);
            examTable.getColumnModel().getColumn(8).setPreferredWidth(0);
            examTable.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        jLabel1.setText("Exam Result");

        jLabel2.setText("Exam Total");

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(examResult, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(examTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(studentId, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(studentName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(examNo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(courseCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(courseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(examNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(examResult, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(examTotal))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(42, 42, 42))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void examTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_examTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) examTable.getModel();
        int selectIndex = examTable.getSelectedRow();
        courseCode.setText(model.getValueAt(selectIndex, 0).toString());
        courseName.setText(model.getValueAt(selectIndex, 1).toString());
         studentId.setText(model.getValueAt(selectIndex , 2).toString());
         studentName.setText(model.getValueAt(selectIndex , 3).toString());
         examNo.setText(model.getValueAt(selectIndex, 4).toString());
         examResult.setText(model.getValueAt(selectIndex, 5).toString());
         examTotal.setText(model.getValueAt(selectIndex, 6).toString());
         statusField.setText(model.getValueAt(selectIndex, 7).toString());
         id.setText(model.getValueAt(selectIndex , 8).toString());
    }//GEN-LAST:event_examTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (courseCode.getText().trim().isEmpty() || 
        courseName.getText().trim().isEmpty() || 
        studentId.getText().trim().isEmpty() || 
        studentName.getText().trim().isEmpty() || 
        examNo.getText().trim().isEmpty()) {

        // Display a message if any fields are empty
        JOptionPane.showMessageDialog(this, "Please select a student's data", 
                                      "Input Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method without proceeding further
    }
         if (validateFields()) {
        // Proceed with the rest of the logic
         try {
        // Ensure fields are not empty
        if (examResult.getText().trim().isEmpty() || examTotal.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter values for both Exam Result and Exam Total.", 
                                          "Input Error", JOptionPane.ERROR_MESSAGE);
            return; // Don't proceed if fields are empty
        }
        
        // Parse the input from examResult and examTotal JTextFields
        double examResultValue = Double.parseDouble(examResult.getText().trim());
        double examTotalValue = Double.parseDouble(examTotal.getText().trim());

        // Check if examResult is 75% or more of examTotal
        double percentage = (examResultValue / examTotalValue) * 100;

        // Determine pass or fail
        if (percentage >= 75) {
            statusField.setText("Passed");
        } else {
            statusField.setText("Failed");
        }

    } catch (NumberFormatException e) {
        // Handle invalid number input
        JOptionPane.showMessageDialog(this, "Please enter valid numbers in the fields.", 
                                      "Input Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit method if the input is invalid
    }
        updateBtn();
    }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseCode;
    private javax.swing.JLabel courseName;
    private javax.swing.JLabel examNo;
    private javax.swing.JTextField examResult;
    public static javax.swing.JTable examTable;
    private javax.swing.JTextField examTotal;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel statusField;
    private javax.swing.JLabel studentId;
    private javax.swing.JLabel studentName;
    // End of variables declaration//GEN-END:variables
}
