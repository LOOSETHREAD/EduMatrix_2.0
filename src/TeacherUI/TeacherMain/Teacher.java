package TeacherUI.TeacherMain;

//import static Data.Controller.PopulateTable.populateCourseToCourseBox;
//import Data.Models.ModelCourse;
import TeacherUI.TeacherForms.VerifyStudent;
import TeacherUI.TeacherForms.TeacherAddCourse;
import TeacherUI.TeacherForms.AddQuiz;
import TeacherUI.TeacherPanels.TeacherQuizDashboard;
import TeacherUI.TeacherPanels.TeacherExamDashboard;
import TeacherUI.TeacherPanels.taecherDashboard;
import Data.Controller.PopulateTable;
import static Data.Controller.PopulateTable.populateCourseToCourseBox;
import Data.Models.ModelCourse;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import Swing.GlassPanePopup;
import Login.Main;
import Swing.EventItem;
import TeacherUI.TeacherForms.AddExam;
import static TeacherUI.TeacherForms.AddQuiz.courseTable;
import static TeacherUI.TeacherForms.ExamInfo.examTable;
import static TeacherUI.TeacherForms.QuizInfo.quizTable;
import java.util.List;

public class Teacher extends javax.swing.JFrame {

    private static taecherDashboard dashh;
    private TeacherAddCourse addcourse;
    private VerifyStudent verify;
    private static TeacherQuizDashboard quizdash;
    private static TeacherExamDashboard examdash;
    private AddQuiz quiz;
    private AddExam exam;
//    private TeacherAddAnnouncement addannounce;

    public Teacher() {
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setBackground(Color.white);
        DASHBOARD.setLayout(new BorderLayout());
//        addannounce = new TeacherAddAnnouncement();
        addcourse = new TeacherAddCourse();
        quizdash = new TeacherQuizDashboard();
        examdash = new TeacherExamDashboard();
        AddQuiz addQuizPanel = new AddQuiz();
        quiz = new AddQuiz();
        exam = new AddExam();
        verify = new VerifyStudent(addQuizPanel);
        GlassPanePopup.install(this);
        dashh = new taecherDashboard();
        forms(dashh);
        test();
        test2();
        test3();
    }

    public void forms(Component con) {
        DASHBOARD.removeAll();
        DASHBOARD.add(con);
        // Revalidate and repaint after adding a new component to the DASHBOARD
        DASHBOARD.revalidate();
        DASHBOARD.repaint();
    }

    public static void test() {
            dashh.setEvent(new EventItem() {
        @Override
        public void itemClick(Component com, ModelCourse data) {
        System.out.println("Clicked course: " + data.getCourseName());
        }
    });
        List<ModelCourse> courses = populateCourseToCourseBox();

        dashh.panelItem1.removeAll();

        // Add the courses to the dashboard
        for (ModelCourse course : courses) {
            dashh.addItem(course);
        }

        // Refresh the dashboard UI to display the new courses
        dashh.repaint();
        dashh.revalidate();
    }
    public static void test2() {
            quizdash.setEvent(new EventItem() {
        @Override
        public void itemClick(Component com, ModelCourse data) {
        System.out.println("Clicked course: " + data.getCourseName());
        }
    });
        List<ModelCourse> courses = populateCourseToCourseBox();

        quizdash.panelItem1.removeAll();

        // Add the courses to the dashboard
        for (ModelCourse course : courses) {
            quizdash.addItem(course);
        }

        // Refresh the dashboard UI to display the new courses
        quizdash.repaint();
        quizdash.revalidate();
    }
    public static void test3() {
            examdash.setEvent(new EventItem() {
        @Override
        public void itemClick(Component com, ModelCourse data) {
        System.out.println("Clicked course: " + data.getCourseName());
        }
    });
        List<ModelCourse> courses = populateCourseToCourseBox();

        examdash.panelItem1.removeAll();

        // Add the courses to the dashboard
        for (ModelCourse course : courses) {
            examdash.addItem(course);
        }

        // Refresh the dashboard UI to display the new courses
        examdash.repaint();
        examdash.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DASHBOARD = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelBorder1 = new Swing.PanelBorder();
        fullName1 = new javax.swing.JLabel();
        teacherId = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Btndash = new javax.swing.JButton();
        Btn1 = new javax.swing.JButton();
        Btn2 = new javax.swing.JButton();
        Btndash1 = new javax.swing.JButton();
        logBtn = new javax.swing.JButton();
        Btndash2 = new javax.swing.JButton();
        Btndash3 = new javax.swing.JButton();
        Btndash4 = new javax.swing.JButton();

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
            .addGap(0, 807, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelBorder1.setBackground(new java.awt.Color(41, 78, 89));

        fullName1.setForeground(new java.awt.Color(255, 255, 255));
        panelBorder1.add(fullName1);
        fullName1.setBounds(20, 10, 127, 31);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(teacherId, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 951, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teacherId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(41, 78, 89));

        Btndash.setBackground(new java.awt.Color(0, 102, 102));
        Btndash.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Btndash.setForeground(new java.awt.Color(255, 255, 255));
        Btndash.setText("Quizes");
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
        Btn1.setText("Add Course");
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
        Btn2.setText("Verify Students");
        Btn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Btn2.setBorderPainted(false);
        Btn2.setContentAreaFilled(false);
        Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn2ActionPerformed(evt);
            }
        });

        Btndash1.setBackground(new java.awt.Color(0, 102, 102));
        Btndash1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Btndash1.setForeground(new java.awt.Color(255, 255, 255));
        Btndash1.setText("Dashboard");
        Btndash1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Btndash1.setBorderPainted(false);
        Btndash1.setContentAreaFilled(false);
        Btndash1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btndash1ActionPerformed(evt);
            }
        });

        logBtn.setBackground(new java.awt.Color(0, 102, 102));
        logBtn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        logBtn.setForeground(new java.awt.Color(255, 255, 255));
        logBtn.setText("Logout");
        logBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        logBtn.setBorderPainted(false);
        logBtn.setContentAreaFilled(false);
        logBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logBtnActionPerformed(evt);
            }
        });

        Btndash2.setBackground(new java.awt.Color(0, 102, 102));
        Btndash2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Btndash2.setForeground(new java.awt.Color(255, 255, 255));
        Btndash2.setText("Add Quiz");
        Btndash2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Btndash2.setBorderPainted(false);
        Btndash2.setContentAreaFilled(false);
        Btndash2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btndash2ActionPerformed(evt);
            }
        });

        Btndash3.setBackground(new java.awt.Color(0, 102, 102));
        Btndash3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Btndash3.setForeground(new java.awt.Color(255, 255, 255));
        Btndash3.setText("Exams");
        Btndash3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Btndash3.setBorderPainted(false);
        Btndash3.setContentAreaFilled(false);
        Btndash3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btndash3ActionPerformed(evt);
            }
        });

        Btndash4.setBackground(new java.awt.Color(0, 102, 102));
        Btndash4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Btndash4.setForeground(new java.awt.Color(255, 255, 255));
        Btndash4.setText("Add Exam");
        Btndash4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Btndash4.setBorderPainted(false);
        Btndash4.setContentAreaFilled(false);
        Btndash4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btndash4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btndash1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btndash, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
            .addComponent(Btndash2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btndash3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
            .addComponent(Btndash4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(Btndash1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btndash2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btndash4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btndash, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btndash3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DASHBOARD, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(DASHBOARD, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtndashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtndashActionPerformed
    forms(quizdash);
    test2();
    }//GEN-LAST:event_BtndashActionPerformed

    private void Btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn2ActionPerformed
        GlassPanePopup.showPopup(verify);
    }//GEN-LAST:event_Btn2ActionPerformed

    private void Btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn1ActionPerformed

    GlassPanePopup.showPopup(addcourse);
    }//GEN-LAST:event_Btn1ActionPerformed

    private void logBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logBtnActionPerformed
        // TODO add your handling code here:
        Main main = new Main();
        main.setVisible(true);
        dispose();
    }//GEN-LAST:event_logBtnActionPerformed

    private void Btndash1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btndash1ActionPerformed
        // TODO add your handling code here:
        forms(dashh);
    }//GEN-LAST:event_Btndash1ActionPerformed

    private void Btndash2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btndash2ActionPerformed
        // TODO add your handling code here:
        GlassPanePopup.showPopup(quiz);
    }//GEN-LAST:event_Btndash2ActionPerformed

    private void Btndash3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btndash3ActionPerformed
        // TODO add your handling code here:
        forms(examdash);
        test3();
    }//GEN-LAST:event_Btndash3ActionPerformed

    private void Btndash4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btndash4ActionPerformed
        // TODO add your handling code here:
        GlassPanePopup.showPopup(exam);
    }//GEN-LAST:event_Btndash4ActionPerformed


   
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
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn1;
    private javax.swing.JButton Btn2;
    private javax.swing.JButton Btndash;
    private javax.swing.JButton Btndash1;
    private javax.swing.JButton Btndash2;
    private javax.swing.JButton Btndash3;
    private javax.swing.JButton Btndash4;
    private javax.swing.JPanel DASHBOARD;
    public javax.swing.JLabel fullName1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logBtn;
    public Swing.PanelBorder panelBorder1;
    public javax.swing.JLabel teacherId;
    // End of variables declaration//GEN-END:variables
}
