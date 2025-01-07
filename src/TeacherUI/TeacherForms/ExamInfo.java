package TeacherUI.TeacherForms;
import Data.Controller.AddData;
import static Data.Controller.PopulateTable.PopulateStudentInfoToExamTable;
import Data.Models.ModelExam;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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
        examTable.getTableHeader().setReorderingAllowed(false);
        examTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        centerDataTable1();
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
    datacontroller.updateStudentExamToDatabase(updatedData, idData);
    PopulateStudentInfoToExamTable(ExamInfo.examTable,examName, courseCodeToUpdate);
    TextFieldEmpty();
}
        private void centerDataTable1(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < examTable.getColumnModel().getColumnCount(); i++) {
            examTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) examTable.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private boolean validateFields() {
    if (examResult.getText().trim().isEmpty() || examTotal.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter values for both Exam Result and Exam Total.", 
                                      "Input Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    try {
        Double.parseDouble(examResult.getText().trim());
        Double.parseDouble(examTotal.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers in the fields.", 
                                      "Input Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}
    private void UpdateBtn(){
        if (courseCode.getText().trim().isEmpty() || 
        courseName.getText().trim().isEmpty() || 
        studentId.getText().trim().isEmpty() || 
        studentName.getText().trim().isEmpty() || 
        examNo.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a student's data", 
                                      "Input Error", JOptionPane.ERROR_MESSAGE);
        return;     }
         if (validateFields()) {
         try {
        if (examResult.getText().trim().isEmpty() || examTotal.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter values for both Exam Result and Exam Total.", 
                                          "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double examResultValue = Double.parseDouble(examResult.getText().trim());
        double examTotalValue = Double.parseDouble(examTotal.getText().trim());
        double percentage = (examResultValue / examTotalValue) * 100;
        if (percentage >= 75) {
            statusField.setText("Passed");
        } else {
            statusField.setText("Failed");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers in the fields.", 
                                      "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        updateBtn();
    }
    }
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
        courseCode = new javax.swing.JLabel();
        courseName = new javax.swing.JLabel();
        studentId = new javax.swing.JLabel();
        studentName = new javax.swing.JLabel();
        examNo = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        pictureBox1 = new Swing.PictureBox();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 78, 89), 5));

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
                false, false, false, false, false, false, false, false, false
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

        examTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                examTotalKeyPressed(evt);
            }
        });

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-available-updates-48 (1).png"))); // NOI18N
        pictureBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox1MouseClicked(evt);
            }
        });

        jLabel3.setText("Update");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentName)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addComponent(examNo)
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(examResult, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(examTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(45, 45, 45)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(courseCode)
                        .addGap(37, 37, 37)
                        .addComponent(courseName))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(studentId)
                        .addGap(351, 351, 351)
                        .addComponent(id)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(examTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(examResult, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addComponent(examNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseCode))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(statusField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pictureBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(id)
                        .addContainerGap())))
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

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         UpdateBtn();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void pictureBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseClicked
        UpdateBtn();
    }//GEN-LAST:event_pictureBox1MouseClicked

    private void examTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_examTotalKeyPressed
       if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        UpdateBtn();
    }
    }//GEN-LAST:event_examTotalKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseCode;
    private javax.swing.JLabel courseName;
    private javax.swing.JLabel examNo;
    private javax.swing.JTextField examResult;
    public static javax.swing.JTable examTable;
    private javax.swing.JTextField examTotal;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private Swing.PictureBox pictureBox1;
    private javax.swing.JLabel statusField;
    private javax.swing.JLabel studentId;
    private javax.swing.JLabel studentName;
    // End of variables declaration//GEN-END:variables
}
