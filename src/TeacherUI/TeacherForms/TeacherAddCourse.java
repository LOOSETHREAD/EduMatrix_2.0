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
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author User
 */
public class TeacherAddCourse extends javax.swing.JPanel {
    
       private AddData datacontroller;
    private DefaultTableModel courseTableModel;
    
    public TeacherAddCourse() {
        FlatLightLaf.setup();
        initComponents();
        idcourselist.setVisible(false);
        courseCode.setVisible(false);
        datacontroller = new AddData(courseTableModel);
        populateCourseTable(courseTable);
        centerDataTable();
    }
    public JTable getCourseTable() {
    return courseTable; // Return the JTable instance
}
    private void centerDataTable(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i <courseTable.getColumnModel().getColumnCount(); i++) {
            courseTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Center the header text
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) courseTable.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    }
   public void addBtn() {
    // Validate that the course name field is not empty
    if (courseName.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Course name cannot be empty. Please enter a course name.", "Validation Error", JOptionPane.WARNING_MESSAGE);
        return; // Exit the method if validation fails
    }

    // Generate a course code
    GenerateCode();

    // Create a new course object
    ModelCourse newdata = new ModelCourse(courseCode.getText(), courseName.getText().trim());

    // Add course to the database
    datacontroller.addCourseToDatabase(newdata);

    // Update the course table in the UI
    populateCourseTable(courseTable);
    PopulateTable.populateCourseTable(AddQuiz.courseTable);
    PopulateTable.populateCourseTable(AddExam.courseTable);

    // Clear text fields and perform additional actions
    TextFieldEmpty();
    Teacher.test();
    Teacher.test2();
}


    public void deleteBtn() {
    String courseCodeToDelete = courseCode.getText().trim(); // Trim input to avoid accidental spaces

    // Validate that the course code field is not empty
    if (courseCodeToDelete.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select a course to delete.", "Validation Error", JOptionPane.WARNING_MESSAGE);
        return; // Exit the method if validation fails
    }

    // Create necessary model objects for deletion
    ModelCourse newdata = new ModelCourse(courseCodeToDelete, courseName.getText().trim());
    ModelStudentToCourse data = new ModelStudentToCourse(courseCodeToDelete, courseName.getText().trim());
    ModelQuiz quiz = new ModelQuiz(courseCodeToDelete, courseName.getText().trim());
    ModelExam exam = new ModelExam(courseCodeToDelete, courseName.getText().trim());

    // Perform deletion operations
    datacontroller.deleteCourseToDatabase(newdata);
    datacontroller.deleteCourseToStudentCourse(data);
    datacontroller.deleteQuizCourseToQuizList(quiz);
    datacontroller.deleteExamCourseToExamList(exam);
    datacontroller.deleteQuizCourseToStudentCourse(data);
    datacontroller.deleteExamCourseToStudentCourse(data);

    // Update the relevant tables
    populateCourseTable(courseTable);
    PopulateTable.populateQuizToAddQuizTable(AddQuiz.quizTable);
    PopulateTable.populateCourseTable(AddQuiz.courseTable);
    PopulateTable.populateExamToAddExamTable(AddExam.examTable);
    PopulateTable.populateCourseTable(AddExam.courseTable);

    // Clear text fields and perform additional actions
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
        idcourselist = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pictureBox2 = new Swing.PictureBox();
        pictureBox1 = new Swing.PictureBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 78, 89), 6));

        courseTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        courseName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Course List");

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-remove-48 (1).png"))); // NOI18N
        pictureBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox2MouseClicked(evt);
            }
        });

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-add-48 (1).png"))); // NOI18N
        pictureBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox1MouseClicked(evt);
            }
        });

        jLabel3.setText("Add");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setText("Delete");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                    .addComponent(courseName)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseCode)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(idcourselist)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(pictureBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(idcourselist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseCode))
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
    
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        addBtn();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void pictureBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseClicked
        // TODO add your handling code here:
        addBtn();
    }//GEN-LAST:event_pictureBox1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        deleteBtn();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void pictureBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseClicked
        // TODO add your handling code here:
        deleteBtn();
    }//GEN-LAST:event_pictureBox2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseCode;
    private javax.swing.JTextField courseName;
    private javax.swing.JTable courseTable;
    private javax.swing.JLabel idcourselist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private Swing.PictureBox pictureBox1;
    private Swing.PictureBox pictureBox2;
    // End of variables declaration//GEN-END:variables
}
