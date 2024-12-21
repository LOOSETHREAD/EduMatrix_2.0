package TeacherUI.TeacherMain;

//import static Data.Controller.PopulateTable.populateCourseToCourseBox;
//import Data.Models.ModelCourse;
import TeacherUI.TeacherForms.VerifyStudent;
import TeacherUI.TeacherForms.TeacherAddCourse;
import TeacherUI.TeacherForms.AddQuiz;
import TeacherUI.TeacherPanels.TeacherQuizDashboard;
import TeacherUI.TeacherPanels.TeacherExamDashboard;
import TeacherUI.TeacherPanels.taecherDashboard;
import static Data.Controller.PopulateTable.populateCourseToCourseBox;
import Data.Models.ModelCourse;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import Swing.GlassPanePopup;
import Login.Main;
import Swing.EventItem;
import TeacherUI.TeacherForms.AddExam;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Toolkit;
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
        teacherId.setVisible(false);
//        setSize(Toolkit.getDefaultToolkit().getScreenSize());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        DASHBOARD = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelBorder1 = new Swing.PanelBorder();
        fullName1 = new javax.swing.JLabel();
        pictureBox2 = new Swing.PictureBox();
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
        pictureBox1 = new Swing.PictureBox();
        pictureBox3 = new Swing.PictureBox();
        pictureBox4 = new Swing.PictureBox();
        pictureBox5 = new Swing.PictureBox();
        pictureBox6 = new Swing.PictureBox();
        pictureBox7 = new Swing.PictureBox();
        pictureBox8 = new Swing.PictureBox();
        pictureBox9 = new Swing.PictureBox();
        pictureBox10 = new Swing.PictureBox();
        jSeparator1 = new javax.swing.JSeparator();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        DASHBOARD.setBackground(new java.awt.Color(255, 255, 255));
        DASHBOARD.setPreferredSize(new java.awt.Dimension(786, 583));

        javax.swing.GroupLayout DASHBOARDLayout = new javax.swing.GroupLayout(DASHBOARD);
        DASHBOARD.setLayout(DASHBOARDLayout);
        DASHBOARDLayout.setHorizontalGroup(
            DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        DASHBOARDLayout.setVerticalGroup(
            DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelBorder1.setBackground(new java.awt.Color(41, 78, 89));

        fullName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fullName1.setForeground(new java.awt.Color(255, 255, 255));

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-system-administrator-male-48.png"))); // NOI18N

        panelBorder1.setLayer(fullName1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelBorder1.setLayer(pictureBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fullName1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(fullName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(teacherId, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherId, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(41, 78, 89));

        Btndash.setBackground(new java.awt.Color(0, 102, 102));
        Btndash.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Btndash.setForeground(new java.awt.Color(255, 255, 255));
        Btndash.setText("Quizes                     ");
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
        Btn1.setText("Add Course            ");
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
        Btn2.setText(" Verify Students        ");
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
        Btndash1.setText("Dashboard              ");
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
        logBtn.setText("Logout                    ");
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
        Btndash2.setText("Add Quiz                ");
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
        Btndash3.setText("Exams                     ");
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
        Btndash4.setText("Add Exam               ");
        Btndash4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Btndash4.setBorderPainted(false);
        Btndash4.setContentAreaFilled(false);
        Btndash4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btndash4ActionPerformed(evt);
            }
        });

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/EduLogo.png"))); // NOI18N

        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-dashboard-layout-48 (1).png"))); // NOI18N
        pictureBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox3MouseClicked(evt);
            }
        });

        pictureBox4.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-add-document-48.png"))); // NOI18N
        pictureBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox4MouseClicked(evt);
            }
        });

        pictureBox5.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-add-properties-64.png"))); // NOI18N
        pictureBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox5MouseClicked(evt);
            }
        });

        pictureBox6.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-add-folder-64.png"))); // NOI18N
        pictureBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox6MouseClicked(evt);
            }
        });

        pictureBox7.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-team-48.png"))); // NOI18N
        pictureBox7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox7MouseClicked(evt);
            }
        });

        pictureBox8.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-check-document-48 (1).png"))); // NOI18N
        pictureBox8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox8MouseClicked(evt);
            }
        });

        pictureBox9.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-check-inbox-50.png"))); // NOI18N
        pictureBox9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox9MouseClicked(evt);
            }
        });

        pictureBox10.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-logout-64.png"))); // NOI18N
        pictureBox10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pictureBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                    .addComponent(pictureBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                    .addComponent(pictureBox5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                    .addComponent(pictureBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Btndash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btndash4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btndash2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btndash1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pictureBox7, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                    .addComponent(pictureBox8, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                    .addComponent(pictureBox10, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                    .addComponent(pictureBox9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(Btndash3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(Btn2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(logBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btndash1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btndash2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(pictureBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pictureBox5, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(Btndash4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(pictureBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(pictureBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btndash, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(pictureBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btndash3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(pictureBox9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pictureBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DASHBOARD, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DASHBOARD, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
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

    private void pictureBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox3MouseClicked
        // TODO add your handling code here:
        forms(dashh);
    }//GEN-LAST:event_pictureBox3MouseClicked

    private void pictureBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox4MouseClicked
        // TODO add your handling code here:
        GlassPanePopup.showPopup(quiz);
    }//GEN-LAST:event_pictureBox4MouseClicked

    private void pictureBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox5MouseClicked
        // TODO add your handling code here:
        GlassPanePopup.showPopup(exam);
    }//GEN-LAST:event_pictureBox5MouseClicked

    private void pictureBox6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox6MouseClicked
        // TODO add your handling code here:
        GlassPanePopup.showPopup(addcourse);
    }//GEN-LAST:event_pictureBox6MouseClicked

    private void pictureBox7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox7MouseClicked
        // TODO add your handling code here:
        GlassPanePopup.showPopup(verify);
    }//GEN-LAST:event_pictureBox7MouseClicked

    private void pictureBox8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox8MouseClicked
        // TODO add your handling code here:
        forms(quizdash);
    test2();
    }//GEN-LAST:event_pictureBox8MouseClicked

    private void pictureBox9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox9MouseClicked
        // TODO add your handling code here:
        forms(examdash);
        test3();
    }//GEN-LAST:event_pictureBox9MouseClicked

    private void pictureBox10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox10MouseClicked
        // TODO add your handling code here:
        Main main = new Main();
        main.setVisible(true);
        dispose();
    }//GEN-LAST:event_pictureBox10MouseClicked


   
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
        FlatLightLaf.setup();
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
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logBtn;
    public Swing.PanelBorder panelBorder1;
    private Swing.PictureBox pictureBox1;
    private Swing.PictureBox pictureBox10;
    private Swing.PictureBox pictureBox2;
    private Swing.PictureBox pictureBox3;
    private Swing.PictureBox pictureBox4;
    private Swing.PictureBox pictureBox5;
    private Swing.PictureBox pictureBox6;
    private Swing.PictureBox pictureBox7;
    private Swing.PictureBox pictureBox8;
    private Swing.PictureBox pictureBox9;
    public javax.swing.JLabel teacherId;
    // End of variables declaration//GEN-END:variables
}
