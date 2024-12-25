package StudentUI;
import Data.Controller.PopulateTable;
import Data.Models.ModelQuiz;
import Swing.EventItem2;
import java.awt.Component;
import java.util.List;
public class StudentQuizPanel extends javax.swing.JPanel {
    private EventItem2 event;
    private String courseCode;
    public StudentQuizPanel(String courseCode) {
        this.courseCode = courseCode;
        initComponents();
        loadQuizzes();
    }
    public void setEvent(EventItem2 event) {
        this.event = event;
    }
    public void addItem(ModelQuiz data) {
        StudentQuizBox quiz = new StudentQuizBox();
        quiz.setData(data);
        quiz.studentId = Student.data.getStudentid();
        quiz.onClick(event);
        panelItem1.add(quiz);
        refreshPanel();
    }
    private void refreshPanel() {
        repaint();
        revalidate();
    }
    private void loadQuizzes() {
        setEvent(new EventItem2() {
            @Override
            public void itemClick2(Component com, ModelQuiz data) {
            }
        });
        List<ModelQuiz> quizzes = PopulateTable.populateQuizNameToQuizBox(courseCode);
        panelItem1.removeAll();
        for (ModelQuiz quiz : quizzes) {
            addItem(quiz);
        }
        refreshPanel();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelItem1 = new Swing.PanelItem();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(panelItem1);

        jLabel1.setText("Quizes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Swing.PanelItem panelItem1;
    // End of variables declaration//GEN-END:variables

}
