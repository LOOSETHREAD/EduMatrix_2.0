
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
import TeacherUI.TeacherMain.Teacher;
import com.formdev.flatlaf.FlatLightLaf;
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
        
        FlatLightLaf.setup();
        Student.data = user;
        if (user != null) {
        programLabel.setText(user.getProgram());
        studentid.setText(user.getStudentid());
        fullName2.setText(user.getFullname());
            System.out.println("Student program:" + user.getProgram());
        System.out.println("Student ID set: " + user.getStudentid());
    } else {
        System.out.println("Error: ModelStudentUser is null");
    }
//        setSize(Toolkit.getDefaultToolkit().getScreenSize());
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fullName2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        studentid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        programLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        Btndash = new javax.swing.JButton();
        Btn1 = new javax.swing.JButton();
        Btn2 = new javax.swing.JButton();
        LogoutBtn = new javax.swing.JButton();
        LogoutBtn1 = new javax.swing.JButton();
        LogoutBtn3 = new javax.swing.JButton();
        pictureBox1 = new Swing.PictureBox();
        jSeparator1 = new javax.swing.JSeparator();
        pictureBox2 = new Swing.PictureBox();
        pictureBox3 = new Swing.PictureBox();
        pictureBox4 = new Swing.PictureBox();
        pictureBox5 = new Swing.PictureBox();
        pictureBox6 = new Swing.PictureBox();
        pictureBox7 = new Swing.PictureBox();

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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(785, 87));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Name:");

        fullName2.setBackground(new java.awt.Color(41, 78, 89));
        fullName2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        fullName2.setText("hasjdsa hbdsdbd");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Student ID:");

        studentid.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        studentid.setText("afasga");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel3.setText("Bachelor of Science in");

        programLabel.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fullName2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentid, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(programLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addGap(211, 211, 211))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(fullName2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentid, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(programLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(41, 78, 89));
        jPanel2.setPreferredSize(new java.awt.Dimension(211, 602));

        Btndash.setBackground(new java.awt.Color(0, 102, 102));
        Btndash.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Btndash.setForeground(new java.awt.Color(255, 255, 255));
        Btndash.setText("Dashboard              ");
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
        Btn1.setText("Enter Class             ");
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
        Btn2.setText("Exam Result            ");
        Btn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Btn2.setBorderPainted(false);
        Btn2.setContentAreaFilled(false);
        Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn2ActionPerformed(evt);
            }
        });

        LogoutBtn.setBackground(new java.awt.Color(0, 102, 102));
        LogoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.setText("Logout             ");
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
        LogoutBtn1.setText("SPR              ");
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
        LogoutBtn3.setText("Quiz Result              ");
        LogoutBtn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        LogoutBtn3.setBorderPainted(false);
        LogoutBtn3.setContentAreaFilled(false);
        LogoutBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtn3ActionPerformed(evt);
            }
        });

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/EduLogo.png"))); // NOI18N

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-dashboard-layout-48 (1).png"))); // NOI18N

        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-test-result-53.png"))); // NOI18N

        pictureBox4.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-test-50.png"))); // NOI18N

        pictureBox5.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-classroom-64.png"))); // NOI18N

        pictureBox6.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-record-book-50.png"))); // NOI18N

        pictureBox7.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-logout-64.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pictureBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pictureBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pictureBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pictureBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(Btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btndash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LogoutBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LogoutBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LogoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btndash, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogoutBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                    .addComponent(DASHBOARD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DASHBOARD, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
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
                
                ModelStudentUser user = new ModelStudentUser();
                new Student(user).setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private Swing.PictureBox pictureBox1;
    private Swing.PictureBox pictureBox2;
    private Swing.PictureBox pictureBox3;
    private Swing.PictureBox pictureBox4;
    private Swing.PictureBox pictureBox5;
    private Swing.PictureBox pictureBox6;
    private Swing.PictureBox pictureBox7;
    private javax.swing.JLabel programLabel;
    public javax.swing.JLabel studentid;
    // End of variables declaration//GEN-END:variables
}
