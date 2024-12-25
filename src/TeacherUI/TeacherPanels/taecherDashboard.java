package TeacherUI.TeacherPanels;
import TeacherUI.TeacherBoxes.CourseBox;
import Data.Models.ModelCourse;
import Swing.EventItem;
import com.formdev.flatlaf.FlatLightLaf;
public class taecherDashboard extends javax.swing.JPanel {
    public void setEvent(EventItem event) {
        this.event = event;
    }
    public taecherDashboard() {
        initComponents();
        FlatLightLaf.setup();
    }
    private EventItem event;
     public void addItem(ModelCourse data) {
        CourseBox course = new CourseBox();
        course.setData(data);
        course.onClick1(event);
        panelItem1.add(course);
        refreshPanel();
    }
    private void refreshPanel() {
        repaint();
        revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        panelItem1 = new Swing.PanelItem();
        jLabel1 = new javax.swing.JLabel();

        panelItem1.add(jLabel1);

        jScrollPane2.setViewportView(panelItem1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1319, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    public Swing.PanelItem panelItem1;
    // End of variables declaration//GEN-END:variables
}
