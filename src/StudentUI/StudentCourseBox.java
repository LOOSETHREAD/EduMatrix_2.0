package StudentUI;
import Data.Controller.PopulateTable;
import Data.Models.ModelCourse;
import Data.Models.ModelStudentToCourse;
import Swing.EventItem;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import Swing.GlassPanePopup;
import javax.swing.JOptionPane;
public class StudentCourseBox extends JPanel {
public void setSelected(boolean selected) {
        repaint();
    }
    public void setData(ModelCourse data) {
    if (data == null) {
        System.out.println("Error: Trying to set null data in StudentCourseBox.");
        return;
    }
    this.data = data;
    courseCode.setText(data.getCourseCode());
    courseName.setText(data.getCourseName());
}
    public ModelCourse getData() {
    return this.data;
} 
    ModelCourse data;
    public String studentId;
    private String coursecode;
    private String coursename;
    public StudentCourseBox() {
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
   public void onClick(EventItem event) {
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
                var studentList = PopulateTable.populateStudentInfoToStudentInfoBox(
                        coursecode, 
                        studentId, 
                        coursename, 
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
                ModelStudentToCourse studentInfo = studentList.get(0);
                StudentInfoBox studentBox = new StudentInfoBox();
                studentBox.setCourseCode(studentInfo.getCourseCode());
                studentBox.setCourseName(studentInfo.getCourseName());
                studentBox.setGrade(studentInfo.getStudentspr());
                studentBox.setStatus(studentInfo.getStatussp());
                GlassPanePopup.showPopup(studentBox);
                event.itemClick(StudentCourseBox.this, data);
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
        courseCode = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        courseName = new javax.swing.JLabel();

        jLabel1.setText("Course Code");

        jLabel2.setText("Course Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel courseCode;
    public javax.swing.JLabel courseName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
