/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package StudentUI;

import Data.Controller.PopulateTable;
import Data.Models.ModelExam;
import Swing.EventItem3;
import Swing.GlassPanePopup;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class StudentExamBox extends javax.swing.JPanel {

    private ModelExam data;
    public String studentId;
    public String coursecode;
    public String coursename;
    private String examname;
    public StudentExamBox() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        
        g2.dispose();
        super.paint(grphcs);
    }
    public void setData(ModelExam data) {
        this.data = data;
        examName.setText(data.getExamName());
    }
    public void onClick(EventItem3 event) {
    addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            System.out.println("Creating StudentCourseBox for: " + data.getCourseName());
            if (event != null) {
                System.out.println("Triggering event for: " + data.getCourseName());
                System.out.println("Mouse clicked on: " + (data != null ? data.getCourseName() : "null"));
                if (data == null || studentId == null || studentId.trim().isEmpty()) {
                    System.out.println("Error: No data associated with this StudentCourseBox.");
                    System.out.println("Error: No data in StudentCourseBox during click.");
                    JOptionPane.showMessageDialog(null,
                                "Course or Student ID not initialized properly.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println("Error: No data associated with this StudentCourseBox.");
                    return;
                }
                 else {
                    System.out.println("Clicked on course: " + data.getCourseName());
            }

                // Set coursecode and coursename from data
                coursecode = data.getCourseCode();
                coursename = data.getCourseName();
                examname = data.getExamName();
                System.out.println("quiz name is : " + data.getExamName());
                // Fetch the student data
                var studentList = PopulateTable.populateExamInfoToStudentQuizBox(
            coursecode,
            coursename,
             studentId, 
             examname,    // Use quizname for matching quiznumber
                "",
                "",
               "" 
// Optional SPR status
);
                System.out.println("Matching quizname: " + examname + " with quiznumber in database.");


                if (studentList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, 
                            "No data found for the selected course and student.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println("Query returned no results. Verify the following parameters:");
                    System.out.println("Student ID: " + studentId);
                    System.out.println("Course Code: " + coursecode);
                    System.out.println("Course Name: " + coursename);
                    System.out.println("Exam Name: " + examname);
                    return;
                }

                // Assume only one record per student-course combination
                ModelExam studentInfo = studentList.get(0);

                // Create and populate the StudentInfoBox
                StudentExamResultBox studentExamBox = new StudentExamResultBox();
                studentExamBox.setCourseCode(studentInfo.getCourseCode());
                studentExamBox.setCourseName(studentInfo.getCourseName());
                studentExamBox.setGrade(studentInfo.getExamResult());
                studentExamBox.setStatus(studentInfo.getExamStatus());
                studentExamBox.setExamName(studentInfo.getExamName());
                studentExamBox.setTotal(studentInfo.getExamTotal());
                

                // Show the popup
                GlassPanePopup.showPopup(studentExamBox);

                // Trigger the click event callback
                event.itemClick3(StudentExamBox.this, data);
            }
            else{
                System.out.println("Error: Event handler is null.");
                
            }
        }
    });
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        examName = new javax.swing.JLabel();

        jLabel1.setText("Exam Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(examName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(examName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel examName;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
