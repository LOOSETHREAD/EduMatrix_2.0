package TeacherUI.TeacherForms;
import Data.Controller.AddData;
import Data.Controller.PopulateTable;
import static Data.Controller.PopulateTable.populateQuizToAddQuizTable;
import Data.Database.DatabaseConnection;
import Data.Models.ModelQuiz;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
public class AddQuiz extends javax.swing.JPanel {
    private AddData datacontroller;
    private DefaultTableModel courseTableModel;
    private DefaultTableModel quizTableModel;
    public AddQuiz() {
        initComponents();
        datacontroller = new AddData(quizTableModel);
        quizTableModel = (DefaultTableModel) quizTable.getModel();
        courseTableModel = (DefaultTableModel) courseTable.getModel();
        PopulateTable.populateQuizToAddQuizTable(quizTable);
        PopulateTable.populateCourseTable(courseTable);
        courseTable.getTableHeader().setReorderingAllowed(false);
        courseTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        quizTable.getTableHeader().setReorderingAllowed(false);
        quizTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        
        centerDataTable1();
        centerDataTable2();
    }
    public JLabel getCourseCodeLabel() {
    return courseCode;
}
    public JLabel getCourseNameLabel() {
    return courseName;
}
    private void TextFieldEmpty(){
        courseCode.setText("");
        courseName.setText("");
        quizName.setText("");
        id.setText("");
    }
    private void centerDataTable1(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < courseTable.getColumnModel().getColumnCount(); i++) {
            courseTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) courseTable.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private void centerDataTable2(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < quizTable.getColumnModel().getColumnCount(); i++) {
            quizTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) quizTable.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public void addData(){
        ModelQuiz newdata = new ModelQuiz(courseCode.getText(), courseName.getText(),quizName.getText());
        datacontroller.addQuizToDatabase(newdata);
        populateQuizToAddQuizTable(quizTable);
        TextFieldEmpty();
    }
    public void deleteData(){
        ModelQuiz newdata = new ModelQuiz(courseCode.getText(), courseName.getText(),quizName.getText());
        datacontroller.DeleteQuizToDatabase(newdata);
        populateQuizToAddQuizTable(quizTable);
        TextFieldEmpty();
    }
    private void AddQuiz(){
        String coursecode = courseCode.getText().trim();
String coursename = courseName.getText().trim();
String quizNameValue = quizName.getText().trim();
if (quizNameValue.isEmpty()) {
    JOptionPane.showMessageDialog(this,
        "Please enter a quiz name before proceeding.",
        "Input Required",
        JOptionPane.WARNING_MESSAGE);
    return;
}
if (coursecode.isEmpty()) {
    JOptionPane.showMessageDialog(this,
        "Please select a course in the course table.",
        "Input Required",
        JOptionPane.WARNING_MESSAGE);
    return;
}
DatabaseConnection dbConnection = DatabaseConnection.getInstance();
try (Connection conn = dbConnection.getConnection()) {
    String checkSQL = "SELECT COUNT(*) AS count FROM quizes WHERE coursecode = ? AND coursename = ? AND quiznumber = ?";
    String selectSQL = "SELECT student_name, studentID FROM student_to_course WHERE coursecode = ?";
    String insertSQL = "INSERT INTO quizes (coursecode, coursename, studentid, fullname, quiznumber, quizresult, quiztotal, status) " +
                       "VALUES (?, ?, ?, ?, ?, '', '', '')";
    try (PreparedStatement checkStmt = conn.prepareStatement(checkSQL)) {
        checkStmt.setString(1, coursecode);
        checkStmt.setString(2, coursename);
        checkStmt.setString(3, quizNameValue);
        try (ResultSet rsCheck = checkStmt.executeQuery()) {
            if (rsCheck.next() && rsCheck.getInt("count") > 0) {
                JOptionPane.showMessageDialog(this,
                    "A quiz with the same course code, course name, and quiz name already exists.",
                    "Duplicate Entry",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
    }
    try (PreparedStatement selectStmt = conn.prepareStatement(selectSQL)) {
        selectStmt.setString(1, coursecode);
        try (ResultSet rs = selectStmt.executeQuery()) {
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this,
                    "No students found for course code: " + coursecode,
                    "No Data",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
                while (rs.next()) {
                    String studentName = rs.getString("student_name");
                    String studentID = rs.getString("studentID");
                    insertStmt.setString(1, coursecode);
                    insertStmt.setString(2, coursename);
                    insertStmt.setString(3, studentID);
                    insertStmt.setString(4, studentName);
                    insertStmt.setString(5, quizNameValue);
                    insertStmt.executeUpdate();
                }
            }
        }
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this,
        "Database error: " + e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}
addData();
    }
    private void DeleteQuiz(){
        String coursecode = courseCode.getText().trim();
         String coursename = courseName.getText().trim();
         String quizNameValue = quizName.getText().trim();
    if (coursecode.isEmpty() || quizNameValue.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Please Select a quiz to delete from the List Table", 
            "Input Required", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    int confirm = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to delete all quizes for course code: " + coursecode + 
        (quizNameValue.isEmpty() ? "?" : " and quiz name: " + quizNameValue + "?"), 
        "Confirm Deletion", 
        JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }
    DatabaseConnection dbConnection = DatabaseConnection.getInstance();
    try (Connection conn = dbConnection.getConnection()) {
        String deleteSQL = "DELETE FROM quizes WHERE coursecode = ?" + 
                           (quizNameValue.isEmpty() ? "" : " AND quiznumber = ?");
        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
            deleteStmt.setString(1, coursecode);
            if (!quizNameValue.isEmpty()) {
                deleteStmt.setString(2, quizNameValue);
            }
            int rowsDeleted = deleteStmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, 
                    "Successfully deleted.", 
                    "Deletion Successful", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No matching data found to delete in the 'quizes' table.", 
                    "No Data", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, 
            "Database error: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    deleteData();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        quizTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        quizName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        courseCode = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        courseName = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        pictureBox1 = new Swing.PictureBox();
        pictureBox2 = new Swing.PictureBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 78, 89), 6));

        quizTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course Code", "Course Name", "Quiz Name", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        quizTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quizTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(quizTable);
        if (quizTable.getColumnModel().getColumnCount() > 0) {
            quizTable.getColumnModel().getColumn(0).setResizable(false);
            quizTable.getColumnModel().getColumn(1).setResizable(false);
            quizTable.getColumnModel().getColumn(2).setResizable(false);
            quizTable.getColumnModel().getColumn(3).setMinWidth(0);
            quizTable.getColumnModel().getColumn(3).setPreferredWidth(0);
            quizTable.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jLabel1.setText("Quiz Name");

        quizName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        quizName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quizNameKeyPressed(evt);
            }
        });

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course Code", "Course Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        jScrollPane2.setViewportView(courseTable);
        if (courseTable.getColumnModel().getColumnCount() > 0) {
            courseTable.getColumnModel().getColumn(0).setResizable(false);
            courseTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setText("Select a Course to add quiz :");

        jLabel3.setText("List of Courses that have quiz :");

        jLabel4.setText("Course Code");

        courseCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Course Name");

        courseName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-add-48 (1).png"))); // NOI18N
        pictureBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox1MouseClicked(evt);
            }
        });

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-remove-48 (1).png"))); // NOI18N
        pictureBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox2MouseClicked(evt);
            }
        });

        jLabel6.setText("Add");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setText("Delete");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quizName)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(courseCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quizName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pictureBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void courseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTableMouseClicked
        // TODO add your handling code here:
        int selectIndex = courseTable.getSelectedRow();
        courseCode.setText(courseTableModel.getValueAt(selectIndex, 0).toString());
        courseName.setText(courseTableModel.getValueAt(selectIndex,1).toString());
    }//GEN-LAST:event_courseTableMouseClicked

    private void quizTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quizTableMouseClicked
        // TODO add your handling code here:
        int selectIndex = quizTable.getSelectedRow();
        courseCode.setText(quizTableModel.getValueAt(selectIndex, 0).toString());
        courseName.setText(quizTableModel.getValueAt(selectIndex,1).toString());
        quizName.setText(quizTableModel.getValueAt(selectIndex, 2).toString());
    }//GEN-LAST:event_quizTableMouseClicked

    private void pictureBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseClicked
        AddQuiz();
    }//GEN-LAST:event_pictureBox1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       AddQuiz();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        DeleteQuiz();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void pictureBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseClicked
       DeleteQuiz();
    }//GEN-LAST:event_pictureBox2MouseClicked

    private void quizNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quizNameKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        AddQuiz();
    }
    }//GEN-LAST:event_quizNameKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseCode;
    private javax.swing.JLabel courseName;
    public static javax.swing.JTable courseTable;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Swing.PictureBox pictureBox1;
    private Swing.PictureBox pictureBox2;
    private javax.swing.JTextField quizName;
    public static javax.swing.JTable quizTable;
    // End of variables declaration//GEN-END:variables
}
