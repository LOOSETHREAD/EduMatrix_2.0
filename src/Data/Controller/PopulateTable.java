/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data.Controller;

import Data.Database.DatabaseConnection;
import Data.Models.ModelCourse;
import Data.Models.ModelExam;
import Data.Models.ModelQuiz;
import Data.Models.ModelStudentToCourse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User
 */
public class PopulateTable {
        public static void populateCourseTable(JTable table) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM courselist";
            ps = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
            

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing rows in the table

            rs = ps.executeQuery();

            // Populate the table with filtered results
            while (rs.next()) {
                String courseCode = rs.getString("coursecode");
                String courseName = rs.getString("coursename");
                int id = rs.getInt("idcourselist");
                    model.addRow(new Object[]{courseCode, courseName, id});
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing connection: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
        public static void populateStudentRequestTable( JTable table) {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        
        ps = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT * FROM studentrequestcourse WHERE status = 'not verified'");
       

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        rs = ps.executeQuery();
        while (rs.next()) {
           
            
                
            
                Vector <Object> v = new Vector<>();
                v.add(rs.getString("fullname"));
                v.add(rs.getString("studentid"));
                v.add(rs.getString("coursecode"));
                v.add(rs.getString("coursename"));
                v.add(rs.getString("status"));
                model.addRow(v);
           
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close resources in finally block to ensure they are always closed
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing connection: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       e.printStackTrace();
        }
    }
   }
//        public static void populateQuizInfoToAddQuizTable( JTable table) {
//    Connection connection = null;
//    PreparedStatement ps = null;
//    ResultSet rs = null;
//
//    try {
//        
//        ps = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT * FROM quizes");
//       
//
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        model.setRowCount(0);
//        rs = ps.executeQuery();
//        while (rs.next()) {
//                String coursecode = rs.getString("coursecode");
//                String courseName = rs.getString("coursename");
//                String studentID = rs.getString("studentid");
//                String studentName = rs.getString("fullname");
//                String quizName = rs.getString("quiznumber");
//                String quizResult = rs.getString("quizresult");
//                String quizTotal = rs.getString("quiztotal");
//                String quizStatus = rs.getString("status");
//                int id = rs.getInt("idquizes");
//                model.addRow(new Object[]{coursecode, courseName,studentID,studentName,quizName,quizResult,quizTotal,quizStatus});
//           
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//    } finally {
//        // Close resources in finally block to ensure they are always closed
//        try {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (connection != null) connection.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error closing connection: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//       e.printStackTrace();
//        }
//    }
//   }
        public static void populateQuizToAddQuizTable( JTable table) {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        
        ps = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT * FROM quizlist");
       

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        rs = ps.executeQuery();
        while (rs.next()) {
                String courseCode = rs.getString("coursecode");
                String courseName = rs.getString("coursename");
                String quizName = rs.getString("quizname");
                int id = rs.getInt("idquizlist");
                model.addRow(new Object[]{courseCode, courseName, quizName, id});
           
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close resources in finally block to ensure they are always closed
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing connection: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       e.printStackTrace();
        }
    }
   }
        public static void populateExamToAddExamTable( JTable table) {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        
        ps = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT * FROM examlist");
       

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        rs = ps.executeQuery();
        while (rs.next()) {
                String courseCode = rs.getString("coursecode");
                String courseName = rs.getString("coursename");
                String examName = rs.getString("examname");
                int id = rs.getInt("idexamlist");
                model.addRow(new Object[]{courseCode, courseName, examName, id});
           
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close resources in finally block to ensure they are always closed
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing connection: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       e.printStackTrace();
        }
    }
   }
        public static void populateStudentToCourseTable(JTable table, String courseCode) {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        String query = "SELECT * FROM student_to_course WHERE coursecode = ?";
        ps = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
        ps.setString(1, courseCode); // Set the courseCode parameter

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows in the table

        rs = ps.executeQuery();

        // Populate the table with filtered results
        while (rs.next()) {
            String courseName = rs.getString("coursename");
            String studentId = rs.getString("studentID");
            String studentName = rs.getString("student_name");
            String status = rs.getString("status");
            String studentSpr= rs.getString("spr");
            String sprStatus = rs.getString("statusspr");
            int id = rs.getInt("idcourses");
            model.addRow(new Object[]{courseCode, courseName, studentId, studentName, status, id, studentSpr, sprStatus});
        } 
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing connection: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

        public static List<ModelCourse> populateCourseToCourseBox() {
    List<ModelCourse> courseList = new ArrayList<>();

     String query = "SELECT coursecode, courseName FROM courselist";

    try (
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(query)
    ) {

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String courseCode = rs.getString("coursecode");
                String courseName = rs.getString("courseName");
                  ModelCourse model = new ModelCourse(courseCode, courseName);
                courseList.add(model);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }

    return courseList; // Return the populated list
}   
        public static void populateCourseTable(JTable table, String StudentID) { 
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        // SQL query to fetch relevant course data for a specific student
        String query = "SELECT coursecode, coursename, spr, statusspr FROM student_to_course WHERE studentID = ?"; 
        connection = DatabaseConnection.getInstance().getConnection();
        ps = connection.prepareStatement(query);
        ps.setString(1, StudentID); // Set the studentID parameter

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows in the table

        rs = ps.executeQuery();

        // Populate the table with the results
        while (rs.next()) {
            String courseCode = rs.getString("coursecode");
            String courseName = rs.getString("coursename");
            String grade = rs.getString("spr"); // Assuming spr is a grade
            String status = rs.getString("statusspr");
            model.addRow(new Object[]{courseCode, courseName, grade, status});
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing connection: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

        public static List<ModelQuiz> populateQuizNameToQuizBox(String courseCode) {
    List<ModelQuiz> quizList = new ArrayList<>();

     String query = "SELECT quizname, coursename FROM quizlist WHERE coursecode = ?";

    try (
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(query)
    ) {
        ps.setString(1, courseCode);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String quizName = rs.getString("quizname");
                String courseName = rs.getString("coursename");
                  ModelQuiz model = new ModelQuiz(courseCode, courseName, quizName);
                quizList.add(model);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }

    return quizList; // Return the populated list
} 
         public static List<ModelExam> populateExamNameToExamBox(String courseCode) {
    List<ModelExam> examList = new ArrayList<>();

     String query = "SELECT examname, coursename FROM examlist WHERE coursecode = ?";

    try (
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(query)
    ) {
        ps.setString(1, courseCode);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String examName = rs.getString("examname");
                String courseName = rs.getString("coursename");
                  ModelExam model = new ModelExam(courseCode, courseName, examName);
                examList.add(model);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }

    return examList; // Return the populated list
} 
         public static List<ModelCourse> populateCourseToCourseBoxStudent(String studentid) {
    List<ModelCourse> courseList = new ArrayList<>();

     String query = "SELECT coursecode, coursename FROM student_to_course WHERE studentID = ?";

    try (
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(query)
    ) {
        ps.setString(1, studentid);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String courseCode = rs.getString("coursecode");
                String courseName = rs.getString("coursename");
                
                  ModelCourse model = new ModelCourse(courseCode, courseName);
                courseList.add(model);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }

    return courseList; // Return the populated list
}
         public static List<ModelStudentToCourse> populateStudentInfoToStudentInfoBox(
    String courseCode,
    String studentid,
    String courseName,
    String studentSpr,
    String sprStatus
) {
    List<ModelStudentToCourse> courseList = new ArrayList<>();

    String query = "SELECT * FROM student_to_course WHERE studentID = ? AND coursecode = ? AND coursename = ?"
             + " AND (spr = ? OR ? = '') AND (statusspr = ? OR ? = '')";


    try (
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(query)
    ) {
        ps.setString(1, studentid);
        ps.setString(2, courseCode);
        ps.setString(3, courseName);
        ps.setString(4, studentSpr);
        ps.setString(5, studentSpr); // For the optional condition
        ps.setString(6, sprStatus);
        ps.setString(7, sprStatus); // For the optional condition


        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ModelStudentToCourse model = new ModelStudentToCourse(
                rs.getString("studentID"),
                rs.getString("coursecode"),
                rs.getString("coursename"),
                rs.getString("spr"),
                rs.getString("statusspr")
            );
            courseList.add(model);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }

    return courseList;
}
         public static List<ModelQuiz> populateQuizInfoToStudentQuizBox(
    String courseCode,
    String courseName,
    String studentid,
    String quizName,
    String quizResult,
    String quizTotal,
    String quizStatus
) {
    List<ModelQuiz> courseList = new ArrayList<>();
    String query = "SELECT * FROM quizes WHERE studentid = ? AND coursecode = ? AND coursename = ? AND quiznumber = ?"
                 + " AND (quizresult = ? OR ? = '') AND (quiztotal = ? OR ? = '') AND (status = ? OR ? = '')";

    try (
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(query)
    ) {
        ps.setString(1, studentid);
        ps.setString(2, courseCode);
        ps.setString(3, courseName);
        ps.setString(4, quizName); // For quiznumber
        ps.setString(5, quizResult);
        ps.setString(6, quizResult);
        ps.setString(7, quizTotal);
        ps.setString(8, quizTotal);
        ps.setString(9, quizStatus);
        ps.setString(10, quizStatus);

        System.out.println("Executing Query: " + ps.toString());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ModelQuiz model = new ModelQuiz(
                rs.getString("coursecode"),
                rs.getString("coursename"),
                rs.getString("studentid"),
                rs.getString("quiznumber"),
                rs.getString("quizresult"),
                rs.getString("quiztotal"),
                rs.getString("status")
            );
            courseList.add(model);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }

    return courseList;
}
          public static List<ModelExam> populateExamInfoToStudentQuizBox(
    String courseCode,
    String courseName,
    String studentid,
    String examName,
    String examResult,
    String examTotal,
    String examStatus
) {
    List<ModelExam> courseList = new ArrayList<>();
    String query = "SELECT * FROM exams WHERE studentid = ? AND coursecode = ? AND coursename = ? AND examnumber = ?"
                 + " AND (examresult = ? OR ? = '') AND (examtotal = ? OR ? = '') AND (status = ? OR ? = '')";

    try (
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(query)
    ) {
        ps.setString(1, studentid);
        ps.setString(2, courseCode);
        ps.setString(3, courseName);
        ps.setString(4, examName); // For quiznumber
        ps.setString(5, examResult);
        ps.setString(6, examResult);
        ps.setString(7, examTotal);
        ps.setString(8, examTotal);
        ps.setString(9, examStatus);
        ps.setString(10, examStatus);

        System.out.println("Executing Query: " + ps.toString());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ModelExam model = new ModelExam(
                rs.getString("coursecode"),
                rs.getString("coursename"),
                rs.getString("studentid"),
                rs.getString("examnumber"),
                rs.getString("examresult"),
                rs.getString("examtotal"),
                rs.getString("status")
            );
            courseList.add(model);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }

    return courseList;
}



//         public static List<ModelQuiz> populateQuizBoxToQuizPanel(
//    String courseCode,
//    String courseName,
//    String quizName
//) {
//    List<ModelQuiz> quizList = new ArrayList<>();
//
//    String query = "SELECT * FROM quizlist WHERE coursecode = ? AND coursename = ? AND quizname = ";
//
//
//    try (
//        Connection connection = DatabaseConnection.getInstance().getConnection();
//        PreparedStatement ps = connection.prepareStatement(query)
//    ) {
//        ps.setString(1, courseCode);
//        ps.setString(2, courseName);
//        ps.setString(3, quizName);
//
//
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//            ModelQuiz model = new ModelQuiz(
//                rs.getString("coursecode"),
//                rs.getString("coursename"),
//                rs.getString("quizname")
//            );
//            quizList.add(model);
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        ex.printStackTrace();
//    }
//
//    return quizList;
//}
//         public static List<ModelQuiz> populateQuizInfoToQuizPanel(
//    String courseCode,
//    String courseName,
//    String studentid,
//    String studentName,
//    String quizName,
//    String quizResult,
//    String quizTotal,
//    String quizStatus
//) {
//    List<ModelQuiz> List = new ArrayList<>();
//
//    String query = "SELECT * FROM quizes WHERE coursecode = ? AND coursename = ? AND studentid = ? AND fullname = ?"
//             + " AND (quiznumber = ? OR ? = '') AND (quizresult = ? OR ? = '') AND (quiztotal = ? OR ? = '') AND (status = ? OR ? = '')";
//
//
//    try (
//        Connection connection = DatabaseConnection.getInstance().getConnection();
//        PreparedStatement ps = connection.prepareStatement(query)
//    ) {
//        
//        ps.setString(1, courseCode);
//        ps.setString(2, courseName);
//        ps.setString(3, studentid);
//        ps.setString(4  , studentName);
//        ps.setString(5, quizName);
//        ps.setString(6, quizName); // For the optional condition
//        ps.setString(7, quizResult);
//        ps.setString(8, quizResult); // For the optional condition
//        ps.setString(9, quizTotal);
//        ps.setString(10, quizTotal);
//        ps.setString(11, quizStatus);
//        ps.setString(12, quizStatus);
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//            ModelQuiz model = new ModelQuiz(
//                rs.getString("coursecode"),
//                rs.getString("coursename"),
//                rs.getString("studentId"),
//                rs.getString("fullname"),
//                rs.getString("quiznumber"),
//                rs.getString("quizresult"),
//                    rs.getString("quiztotal"),
//                rs.getString("status")
//            );
//            System.out.println("ModelQuiz added: " + model);
//            List.add(model);
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        ex.printStackTrace();
//    }
//
//    return List;
//}
         public static void PopulateStudentInfoToQuizTable(JTable table, String quizNumber, String courseCode) {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        String query = "SELECT * FROM quizes WHERE quiznumber = ? AND coursecode = ?";
        ps = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
        ps.setString(1, quizNumber); // Set the courseCode parameter
        ps.setString(2, courseCode);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows in the table

        rs = ps.executeQuery();

        // Populate the table with filtered results
        while (rs.next()) {
            String courseName = rs.getString("coursename");
            String studentId = rs.getString("studentid");
            String studentName = rs.getString("fullname");
            String quizres = rs.getString("quizresult");
            String quiztots = rs.getString("quiztotal");
            String quizStats = rs.getString("status");
            int id = rs.getInt("idquizes");
            model.addRow(new Object[]{courseCode, courseName, studentId, studentName, quizNumber, quizres, quiztots, quizStats, id});
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing connection: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
          public static void PopulateStudentInfoToExamTable(JTable table, String examNumber, String courseCode) {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        String query = "SELECT * FROM exams WHERE examnumber = ? AND coursecode = ?";
        ps = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
        ps.setString(1, examNumber); // Set the courseCode parameter
        ps.setString(2, courseCode);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows in the table

        rs = ps.executeQuery();

        // Populate the table with filtered results
        while (rs.next()) {
            String courseName = rs.getString("coursename");
            String studentId = rs.getString("studentid");
            String studentName = rs.getString("fullname");
            String examres = rs.getString("examresult");
            String examtots = rs.getString("examtotal");
            String examStats = rs.getString("status");
            int id = rs.getInt("idexams");
            model.addRow(new Object[]{courseCode, courseName, studentId, studentName, examNumber, examres, examtots, examStats, id});
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing connection: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}


         
        public static void getUserInfo(String username) {
    // SQL query to retrieve studentid and fullname for the given username
    String sql = "SELECT studentid FROM studentuser WHERE fullname = ?";

    // Establish the database connection using the DatabaseConnection class
    try (Connection conn = DatabaseConnection.getInstance().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Set the username parameter in the prepared statement
        stmt.setString(1, username);

        // Execute the query and get the result set
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Retrieve the studentid and fullname from the result set
                String studentid = rs.getString("studentid");

                // Output the retrieved information
                System.out.println("Student ID: " + studentid);
            } else {
                System.out.println("No user found with the username: " + username);
            }
        }

    } catch (SQLException e) {
        // Handle any SQL exceptions
        e.printStackTrace();
        System.out.println("An error occurred while fetching user info.");
    }
}

}
