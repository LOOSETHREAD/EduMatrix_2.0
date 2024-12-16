
package StudentUI;

import Data.Controller.PopulateTable;
import Data.Models.ModelCourse;
import Data.Models.ModelStudentUser;
import Login.Main;
import Swing.EventItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import Swing.GlassPanePopup;
import java.util.List;

/**
 *
 * @author Administrator
 */
 


public class Student extends javax.swing.JFrame {

     private studentReq Sreq;
     private studentDashboard Sdash;
     private StudentQuizDashboard SquizDash;
     private StudentExamDashboard SexamDash;
     public static ModelStudentUser data;
     public static ModelCourse course;
     private StudentSpr spr;
    public Student(ModelStudentUser user) {
        initComponents();
        Student.data = user;
        if (user != null) {
        studentid.setText(user.getStudentid());
        fullName2.setText(user.getFullname());
        System.out.println("Student ID set: " + user.getStudentid());
    } else {
        System.out.println("Error: ModelStudentUser is null");
    }
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setBackground( Color.white);
        DASHBOARD.setLayout(new BorderLayout());
        SquizDash = new StudentQuizDashboard();
        SexamDash = new StudentExamDashboard();
        spr = new StudentSpr(studentid);
        Sreq = new studentReq(studentid.getText());
         Sdash = new studentDashboard();
         GlassPanePopup.install(this);
              forms(Sdash);
              test();
              test2();
              test3();
    }
    
 public void forms(Component con){
     DASHBOARD.removeAll();
     DASHBOARD.add(con);
     repaint();
     revalidate();
 }
 
public void test() {
    // Debugging to check the data state
    if (data == null) {
        System.out.println("Error: data object is null.");
        return;
    }

    if (data.getStudentid() == null || data.getStudentid().isEmpty()) {
        System.out.println("Error: Student ID is null or empty.");
        return;
    }

    System.out.println("Testing with student ID: " + data.getStudentid());
    
    // Attach the event for item clicks
    Sdash.setEvent(new EventItem() {
        @Override
        public void itemClick(Component com, ModelCourse data) {
            System.out.println("Event triggered. Component: " + com.getClass().getName());
            System.out.println("Received data: " + (data != null ? data.getCourseName() : "null"));
            if (data == null) {
            System.out.println("Error: Clicked course data is null.");
            return;
        }
            System.out.println("Clicked course: " + data.getCourseName());
        }
    });

    // Populate courses
    List<ModelCourse> courses = PopulateTable.populateCourseToCourseBoxStudent(data.getStudentid());
    if (courses == null || courses.isEmpty()) {
        System.out.println("No courses found for student ID: " + data.getStudentid());
        return;
    }
    for (ModelCourse course : courses) {
        System.out.println("Populated course: " + course.getCourseName());
    if (course == null) {
        System.out.println("Warning: Null course found in the list.");
        continue;
    }
    System.out.println("Course: " + course.getCourseName());
}
    Sdash.panelItem1.removeAll();

    // Add courses to the dashboard
    for (ModelCourse course : courses) {
        System.out.println("Adding course: " + course.getCourseName());
        Sdash.addItem(course);
    }
    
    // Refresh the dashboard UI
    Sdash.repaint();
    Sdash.revalidate();
    
}
public void test2() {
    // Debugging to check the data state
    if (data == null) {
        System.out.println("Error: data object is null.");
        return;
    }

    if (data.getStudentid() == null || data.getStudentid().isEmpty()) {
        System.out.println("Error: Student ID is null or empty.");
        return;
    }

    System.out.println("Testing with student ID: " + data.getStudentid());
    
    // Attach the event for item clicks
    SquizDash.setEvent(new EventItem() {
        @Override
        public void itemClick(Component com, ModelCourse data) {
            System.out.println("Event triggered. Component: " + com.getClass().getName());
            System.out.println("Received data: " + (data != null ? data.getCourseName() : "null"));
            if (data == null) {
            System.out.println("Error: Clicked course data is null.");
            return;
        }
            System.out.println("Clicked course: " + data.getCourseName());
        }
    });

    // Populate courses
    List<ModelCourse> courses = PopulateTable.populateCourseToCourseBoxStudent(data.getStudentid());
    if (courses == null || courses.isEmpty()) {
        System.out.println("No courses found for student ID: " + data.getStudentid());
        return;
    }
    for (ModelCourse course : courses) {
        System.out.println("Populated course: " + course.getCourseName());
    if (course == null) {
        System.out.println("Warning: Null course found in the list.");
        continue;
    }
    System.out.println("Course: " + course.getCourseName());
}
    SquizDash.panelItem1.removeAll();

    // Add courses to the dashboard
    for (ModelCourse course : courses) {
        System.out.println("Adding course: " + course.getCourseName());
        SquizDash.addItem(course);
    }
    
    // Refresh the dashboard UI
    SquizDash.repaint();
    SquizDash.revalidate();
    
}
public void test3() {
    // Debugging to check the data state
    if (data == null) {
        System.out.println("Error: data object is null.");
        return;
    }

    if (data.getStudentid() == null || data.getStudentid().isEmpty()) {
        System.out.println("Error: Student ID is null or empty.");
        return;
    }

    System.out.println("Testing with student ID: " + data.getStudentid());
    
    // Attach the event for item clicks
    SexamDash.setEvent(new EventItem() {
        @Override
        public void itemClick(Component com, ModelCourse data) {
            System.out.println("Event triggered. Component: " + com.getClass().getName());
            System.out.println("Received data: " + (data != null ? data.getCourseName() : "null"));
            if (data == null) {
            System.out.println("Error: Clicked course data is null.");
            return;
        }
            System.out.println("Clicked course: " + data.getCourseName());
        }
    });

    // Populate courses
    List<ModelCourse> courses = PopulateTable.populateCourseToCourseBoxStudent(data.getStudentid());
    if (courses == null || courses.isEmpty()) {
        System.out.println("No courses found for student ID: " + data.getStudentid());
        return;
    }
    for (ModelCourse course : courses) {
        System.out.println("Populated course: " + course.getCourseName());
    if (course == null) {
        System.out.println("Warning: Null course found in the list.");
        continue;
    }
    System.out.println("Course: " + course.getCourseName());
}
    SexamDash.panelItem1.removeAll();

    // Add courses to the dashboard
    for (ModelCourse course : courses) {
        System.out.println("Adding course: " + course.getCourseName());
        SexamDash.addItem(course);
    }
    
    // Refresh the dashboard UI
    SexamDash.repaint();
    SexamDash.revalidate();
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DASHBOARD = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelBorder1 = new Swing.PanelBorder();
        fullName2 = new javax.swing.JLabel();
        studentid = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Btndash = new javax.swing.JButton();
        Btn1 = new javax.swing.JButton();
        Btn2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LogoutBtn = new javax.swing.JButton();
        LogoutBtn1 = new javax.swing.JButton();
        LogoutBtn3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        DASHBOARD.setBackground(new java.awt.Color(255, 255, 255));
        DASHBOARD.setPreferredSize(new java.awt.Dimension(786, 583));

        javax.swing.GroupLayout DASHBOARDLayout = new javax.swing.GroupLayout(DASHBOARD);
        DASHBOARD.setLayout(DASHBOARDLayout);
        DASHBOARDLayout.setHorizontalGroup(
            DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DASHBOARDLayout.setVerticalGroup(
            DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(41, 78, 89));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        fullName2.setBackground(new java.awt.Color(41, 78, 89));
        fullName2.setForeground(new java.awt.Color(255, 255, 255));
        fullName2.setOpaque(true);
        panelBorder1.add(fullName2);
        fullName2.setBounds(40, 10, 160, 30);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(studentid, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(studentid, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(41, 78, 89));

        Btndash.setBackground(new java.awt.Color(0, 102, 102));
        Btndash.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Btndash.setForeground(new java.awt.Color(255, 255, 255));
        Btndash.setText("Dashboard");
        Btndash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Btndash.setBorderPainted(false);
        Btndash.setContentAreaFilled(false);
        Btndash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtndashActionPerformed(evt);
            }
        });

        Btn1.setBackground(new java.awt.Color(0, 102, 102));
        Btn1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Btn1.setForeground(new java.awt.Color(255, 255, 255));
        Btn1.setText("Enter Class");
        Btn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Btn1.setBorderPainted(false);
        Btn1.setContentAreaFilled(false);
        Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn1ActionPerformed(evt);
            }
        });

        Btn2.setBackground(new java.awt.Color(0, 102, 102));
        Btn2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Btn2.setForeground(new java.awt.Color(255, 255, 255));
        Btn2.setText("Exam Result");
        Btn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Btn2.setBorderPainted(false);
        Btn2.setContentAreaFilled(false);
        Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edumatrix");

        jLabel3.setBackground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("jLabel3");
        jLabel3.setOpaque(true);

        LogoutBtn.setBackground(new java.awt.Color(0, 102, 102));
        LogoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.setText("Logout");
        LogoutBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        LogoutBtn.setBorderPainted(false);
        LogoutBtn.setContentAreaFilled(false);
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        LogoutBtn1.setBackground(new java.awt.Color(0, 102, 102));
        LogoutBtn1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        LogoutBtn1.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn1.setText("SPR");
        LogoutBtn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        LogoutBtn1.setBorderPainted(false);
        LogoutBtn1.setContentAreaFilled(false);
        LogoutBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtn1ActionPerformed(evt);
            }
        });

        LogoutBtn3.setBackground(new java.awt.Color(0, 102, 102));
        LogoutBtn3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        LogoutBtn3.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn3.setText("Quiz Result");
        LogoutBtn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        LogoutBtn3.setBorderPainted(false);
        LogoutBtn3.setContentAreaFilled(false);
        LogoutBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btndash, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LogoutBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btndash, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(LogoutBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoutBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DASHBOARD, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DASHBOARD, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtndashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtndashActionPerformed
        forms(Sdash);
    }//GEN-LAST:event_BtndashActionPerformed

    private void Btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn2ActionPerformed
        forms(SexamDash);
    }//GEN-LAST:event_Btn2ActionPerformed

    private void Btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn1ActionPerformed
         String currentStudentID = studentid.getText(); // Get the current teacher ID
         String currentFullname = fullName2.getText();
    studentReq.updateStudentID(currentStudentID,currentFullname);
        GlassPanePopup.showPopup(Sreq);
    }//GEN-LAST:event_Btn1ActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:
        Main main = new Main();
        main.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void LogoutBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtn1ActionPerformed
        // TODO add your handling code here:
        GlassPanePopup.showPopup(spr);
    }//GEN-LAST:event_LogoutBtn1ActionPerformed

    private void LogoutBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtn3ActionPerformed
        // TODO add your handling code here:
        forms(SquizDash);
    }//GEN-LAST:event_LogoutBtn3ActionPerformed


   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn1;
    private javax.swing.JButton Btn2;
    private javax.swing.JButton Btndash;
    private javax.swing.JPanel DASHBOARD;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton LogoutBtn1;
    private javax.swing.JButton LogoutBtn3;
    public javax.swing.JLabel fullName2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    public Swing.PanelBorder panelBorder1;
    public javax.swing.JLabel studentid;
    // End of variables declaration//GEN-END:variables
}
