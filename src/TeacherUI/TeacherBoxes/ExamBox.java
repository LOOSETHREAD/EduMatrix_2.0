/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TeacherUI.TeacherBoxes;

import Data.Models.ModelExam;
import Swing.EventItem3;
import Swing.GlassPanePopup;
import TeacherUI.TeacherForms.ExamInfo;
import static Data.Controller.PopulateTable.PopulateStudentInfoToExamTable;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author User
 */
public class ExamBox extends javax.swing.JPanel {

     private ModelExam data;
    public ExamBox() {
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
    public void onClick3(EventItem3 event) {
    addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            if (data == null) {
                System.out.println("Data is null!");
            } else {
                System.out.println("Course Code: " + data.getCourseCode());
            }
            if (event != null && data != null) {
                // Show the popup with course info
                ExamInfo examInfoPopup = new ExamInfo();
                GlassPanePopup.showPopup(examInfoPopup);
                System.out.println("clicked course code " + data.getCourseCode());
//                 Populate the table for the specific courseCode
                PopulateStudentInfoToExamTable(ExamInfo.examTable, data.getExamName(),data.getCourseCode());

                // Trigger the click event callback
                event.itemClick3(ExamBox.this, data);
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
                    .addComponent(examName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(examName, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel examName;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
