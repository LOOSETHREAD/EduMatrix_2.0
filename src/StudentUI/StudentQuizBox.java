package StudentUI;
import Data.Controller.PopulateTable;
import Data.Models.ModelQuiz;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import Swing.EventItem2;
import Swing.GlassPanePopup;
import javax.swing.JOptionPane;
public class StudentQuizBox extends javax.swing.JPanel {
    private ModelQuiz data;
    public String studentId;
    public String coursecode;
    public String coursename;
    private String quizname;
    public StudentQuizBox() {
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
    public void setData(ModelQuiz data) {
        this.data = data;
        quizName.setText(data.getQuizName());
    }
    public void onClick(EventItem2 event) {
    addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            if (event != null) {
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
                coursecode = data.getCourseCode();
                coursename = data.getCourseName();
                quizname = data.getQuizName();
                var studentList = PopulateTable.populateQuizInfoToStudentQuizBox(
            coursecode,
            coursename,
             studentId, 
             quizname,
                "",
                "",
               "" 
);
                if (studentList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, 
                            "No data found for the selected course and student.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ModelQuiz studentInfo = studentList.get(0);
                StudentQuizResultBox studentQuizBox = new StudentQuizResultBox();
                studentQuizBox.setCourseCode(studentInfo.getCourseCode());
                studentQuizBox.setCourseName(studentInfo.getCourseName());
                studentQuizBox.setGrade(studentInfo.getQuizResult());
                studentQuizBox.setStatus(studentInfo.getQuizStatus());
                studentQuizBox.setQuizName(studentInfo.getQuizName());
                studentQuizBox.setTotal(studentInfo.getQuizTotal());
                GlassPanePopup.showPopup(studentQuizBox);
                event.itemClick2(StudentQuizBox.this, data);
            }
            else{
                System.out.println("Error: Event handler is null.");
            }
        }
    });
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        quizName = new javax.swing.JLabel();

        jLabel1.setText("Quiz Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quizName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quizName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel quizName;
    // End of variables declaration//GEN-END:variables
}
