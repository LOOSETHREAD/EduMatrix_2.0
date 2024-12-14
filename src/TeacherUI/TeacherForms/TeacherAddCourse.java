/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TeacherUI.TeacherForms;

import Data.Controller.AddData;
import Data.Controller.PopulateTable;
import static Data.Controller.PopulateTable.populateCourseTable;
import Data.Database.DatabaseConnection;
import Data.Models.ModelCourse;
import Data.Models.ModelExam;
import Data.Models.ModelQuiz;
import Data.Models.ModelStudentToCourse;
import static TeacherUI.TeacherForms.AddQuiz.courseTable;
import static TeacherUI.TeacherForms.ExamInfo.examTable;
import static TeacherUI.TeacherForms.QuizInfo.quizTable;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JTable;
import TeacherUI.TeacherMain.Teacher;

/**
 *
 * @author User
 */
public class TeacherAddCourse extends javax.swing.JPanel {
    
       private AddData datacontroller;
    private DefaultTableModel courseTableModel;
    
    public TeacherAddCourse() {
        
        initComponents();
        
        idcourselist.setVisible(false);
        courseCode.setVisible(false);
        datacontroller = new AddData(courseTableModel);
        populateCourseTable(courseTable);
    }
    public JTable getCourseTable() {
    return courseTable; // Return the JTable instance
}
    public void addBtn() {
        GenerateCode();
        ModelCourse newdata = new ModelCourse(courseCode.getText(), courseName.getText());
        // Add course to the database
        datacontroller.addCourseToDatabase(newdata);
        populateCourseTable(courseTable);
        TextFieldEmpty();
        Teacher.test();
        Teacher.test2();
    }

    public void deleteBtn() {
    String courseCodeToDelete = courseCode.getText(); // Identify the course to delete
    ModelCourse newdata = new ModelCourse(courseCodeToDelete, courseName.getText());
    ModelStudentToCourse data = new ModelStudentToCourse(courseCodeToDelete, courseName.getText());
    ModelQuiz quiz = new ModelQuiz(courseCodeToDelete, courseName.getText());
    ModelExam exam = new ModelExam(courseCodeToDelete, courseName.getText());
    // Delete the course from the database
    datacontroller.deleteCourseToDatabase(newdata);
    datacontroller.deleteCourseToStudentCourse(data);
    datacontroller.deleteQuizCourseToQuizList(quiz);
    datacontroller.deleteExamCourseToExamList(exam);
    datacontroller.deleteQuizCourseToStudentCourse(data);
    
    datacontroller.deleteExamCourseToStudentCourse(data);
    // Update the table
    populateCourseTable(courseTable);
    
    PopulateTable.populateQuizToAddQuizTable(AddQuiz.quizTable);
    PopulateTable.populateCourseTable(AddQuiz.courseTable);
    PopulateTable.populateExamToAddExamTable(AddExam.examTable);
    PopulateTable.populateCourseTable(AddExam.courseTable);
    TextFieldEmpty();
    Teacher.test();
    Teacher.test2();
}

//   public void updateBtn() {
//    int idData = Integer.parseInt(idcourselist.getText());
//    
//    String courseCodeToUpdate = courseCode.getText();
//    ModelCourse updatedData = new ModelCourse(courseCodeToUpdate, courseName.getText());
//    ModelStudentToCourse data = new ModelStudentToCourse(courseCodeToUpdate, courseName.getText());
//    // Update the course in the database
//    datacontroller.updateCourseToDatabase(updatedData, idData);
//    datacontroller.updateCourseToStudentCourse(data, idData);
//    // Update the table
//    populateCourseTable(courseTable);
//    TextFieldEmpty();
//}

    public void TextFieldEmpty(){
        courseCode.setText("");
        courseName.setText("");
    }
    
    
    public void GenerateCode() {
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    StringBuilder code;
    java.util.Random random = new java.util.Random();
    boolean isUnique;

    do {
        code = new StringBuilder();

        // Generate a 7-character code
        for (int i = 0; i < 7; i++) {
            int index = random.nextInt(chars.length());
            code.append(chars.charAt(index));
        }

        // Check if the code is unique in the database
        isUnique = checkCodeUniqueness(code.toString());
    } while (!isUnique); // Repeat if the code exists

    // Set the generated code to the JLabel courseCode
    courseCode.setText(code.toString());
}

private boolean checkCodeUniqueness(String code) {
    String sql = "SELECT COUNT(*) FROM courselist WHERE coursecode = ?";
    try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
        ps.setString(1, code);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) == 0; // Returns true if no matching record is found
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Assume not unique if an error occurs
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
        courseTable = new javax.swing.JTable();
        courseCode = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        courseName = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        idcourselist = new javax.swing.JLabel();

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Code", "Course Name", "idcourselist"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        courseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(courseTable);
        if (courseTable.getColumnModel().getColumnCount() > 0) {
            courseTable.getColumnModel().getColumn(0).setResizable(false);
            courseTable.getColumnModel().getColumn(1).setResizable(false);
            courseTable.getColumnModel().getColumn(2).setMinWidth(0);
            courseTable.getColumnModel().getColumn(2).setPreferredWidth(0);
            courseTable.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        jLabel1.setText("Course Name");

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(idcourselist, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(idcourselist, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void courseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        int selectIndex = courseTable.getSelectedRow();
        courseCode.setText(model.getValueAt(selectIndex, 0).toString());
        courseName.setText(model.getValueAt(selectIndex, 1).toString());
         idcourselist.setText(model.getValueAt(selectIndex , 2).toString());
    }//GEN-LAST:event_courseTableMouseClicked
    
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        addBtn();
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        deleteBtn();
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel courseCode;
    private javax.swing.JTextField courseName;
    private javax.swing.JTable courseTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel idcourselist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
