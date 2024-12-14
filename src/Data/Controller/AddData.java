
package Data.Controller;

import Data.Database.DatabaseConnection;
import Data.Models.ModelCourse;
import Data.Models.ModelExam;
import Data.Models.ModelQuiz;
import Data.Models.ModelStudentToCourse;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;

        

/**
 *
 * @author User
 */
public class AddData {
    private DefaultTableModel tableModel;
    private PreparedStatement p;
    public AddData(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
        
   public void addCourseToDatabase(ModelCourse addData) {
    PreparedStatement p = null;
    try {
        // Query to check for duplicate entries
        String checkDuplicateSQL = "SELECT COUNT(*) FROM courselist WHERE coursecode = ? OR coursename = ?";

        // Query to insert data
        String insertSQL = "INSERT INTO courselist (coursecode, coursename) VALUES (?, ?)";

        Connection conn = DatabaseConnection.getInstance().getConnection();

        // Check for duplicates
        try (PreparedStatement checkStmt = conn.prepareStatement(checkDuplicateSQL)) {
            checkStmt.setString(1, addData.getCourseCode());
            checkStmt.setString(2, addData.getCourseName());

            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, 
                        "This course already exists in the database.", 
                        "Duplicate Entry", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }

        // Prepare the INSERT statement
        p = conn.prepareStatement(insertSQL);
        p.setString(1, addData.getCourseCode());
        p.setString(2, addData.getCourseName());

        int rowsAffected = p.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Data Added Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add data.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Adding data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (p != null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    public void deleteCourseToDatabase(ModelCourse deleteData) {
    try {
       String sql = "DELETE FROM courselist WHERE coursecode = ? AND coursename = ?";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, deleteData.getCourseCode());
        p.setString(2, deleteData.getCourseName());
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data deleted Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "Failed to delete data.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Deleting data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }
    public void deleteCourseToStudentCourse(ModelStudentToCourse deleteData) {
    try {
       String sql = "DELETE FROM student_to_course WHERE coursecode = ? AND coursename = ?";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, deleteData.getCourseCode());
        p.setString(2, deleteData.getCourseName());
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data deleted Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "Failed to delete data.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Deleting data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }
    public void deleteQuizCourseToStudentCourse(ModelStudentToCourse deleteData) {
    try {
       String sql = "DELETE FROM quizes WHERE coursecode = ? AND coursename = ?";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, deleteData.getCourseCode());
        p.setString(2, deleteData.getCourseName());
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data deleted Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "No matching data from database.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Deleting data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }
    public void deleteQuizCourseToQuizList(ModelQuiz deleteData) {
    try {
       String sql = "DELETE FROM quizlist WHERE coursecode = ? AND coursename = ?";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, deleteData.getCourseCode());
        p.setString(2, deleteData.getCourseName());
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data deleted Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "No matching data from database.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Deleting data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }
    public void deleteExamCourseToExamList(ModelExam deleteData) {
    try {
       String sql = "DELETE FROM examlist WHERE coursecode = ? AND coursename = ?";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, deleteData.getCourseCode());
        p.setString(2, deleteData.getCourseName());
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data deleted Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "No matching data from database.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Deleting data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }
    public void deleteExamCourseToStudentCourse(ModelStudentToCourse deleteData) {
    try {
       String sql = "DELETE FROM exams WHERE coursecode = ? AND coursename = ?";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, deleteData.getCourseCode());
        p.setString(2, deleteData.getCourseName());
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data deleted Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "No matching data from database.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Deleting data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }
//    public void updateCourseToDatabase(ModelCourse updateData, int idcourselist) {
//    try {
//       String sql = "UPDATE courselist SET coursecode = ?, coursename = ? WHERE idcourselist = ?";
//        
//        
//        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
//        p.setString(1, updateData.getCourseCode());
//        p.setString(2, updateData.getCourseName());
//        p.setInt(3, idcourselist);
//        int rowsAffected = p.executeUpdate();
//        if(rowsAffected > 0)
//        {
//            JOptionPane.showMessageDialog(null, "Data updated Succesfully");
//        }else{
//            JOptionPane.showMessageDialog(null, "Failed to update data.");
//            
//        }
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(null, "Error Updating data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        
//    }finally{
//        try {
//            if (p !=null) p.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    }   
//    public void updateCourseToStudentCourse(ModelStudentToCourse updateData, int idcourses) {
//    try {
//       String sql = "UPDATE student_to_course SET coursecode = ?, coursename = ? WHERE idcourses = ?";
//        
//        
//        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
//        p.setString(1, updateData.getCourseCode());
//        p.setString(2, updateData.getCourseName());
//        p.setInt(3, idcourses);
//        int rowsAffected = p.executeUpdate();
//        if(rowsAffected > 0)
//        {
//            JOptionPane.showMessageDialog(null, "Data updated Succesfully");
//        }else{
//            JOptionPane.showMessageDialog(null, "Failed to update data.");
//            
//        }
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(null, "Error Updating data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        
//    }finally{
//        try {
//            if (p !=null) p.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    } 
    public void addQuizToDatabase(ModelQuiz addData) {
    try {
       String sql = "INSERT INTO quizlist (coursecode, coursename,quizname) VALUES (?, ?, ?)";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, addData.getCourseCode());
        p.setString(2, addData.getCourseName());
        p.setString(3, addData.getQuizName());
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data Added Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "Failed to add data.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Adding data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
    public void DeleteQuizToDatabase(ModelQuiz deleteData) {
    try {
       String sql = "DELETE FROM quizlist WHERE coursecode = ? AND coursename = ? AND quizname = ?";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, deleteData.getCourseCode());
        p.setString(2, deleteData.getCourseName());
        p.setString(3, deleteData.getQuizName());
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data Deleted Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "Failed to delete data.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Deleting data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
    
    
 public void updateStudentTOCourse(ModelStudentToCourse updateData, int idcourselist) {
    try {
       String sql = "UPDATE student_to_course SET coursecode = ?, coursename = ?, student_name = ?, studentID = ?, status = ?, spr = ?, statusspr = ? WHERE idcourses = ?";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, updateData.getCourseCode());
        p.setString(2, updateData.getCourseName());
        p.setString(3, updateData.getStudentName());
        p.setString(4, updateData.getStudentID());
        p.setString(5, updateData.getStudentStats());
        p.setString(6, updateData.getStudentspr());
        p.setString(7, updateData.getStatussp());
        p.setInt(8, idcourselist);
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data updated Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "Failed to update data.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Updating data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
  public void addExamToDatabase(ModelExam addData) {
    try {
       String sql = "INSERT INTO examlist (coursecode, coursename,examname) VALUES (?, ?, ?)";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, addData.getCourseCode());
        p.setString(2, addData.getCourseName());
        p.setString(3, addData.getExamName());
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data Added Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "Failed to add data.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Adding data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
  public void DeleteExamToDatabase(ModelExam deleteData) {
    try {
       String sql = "DELETE FROM examlist WHERE coursecode = ? AND coursename = ? AND examname = ?";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, deleteData.getCourseCode());
        p.setString(2, deleteData.getCourseName());
        p.setString(3, deleteData.getExamName());
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data Deleted Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "Failed to delete data.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Deleting data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
  
 public void updateStudentQuizToDatabase(ModelQuiz updateData, int idquizes) {
    try {
       String sql = "UPDATE quizes SET coursecode = ?, coursename = ?, studentID = ?, fullname = ?, quiznumber = ?, quizresult = ?, quiztotal = ?, status = ? WHERE idquizes = ?";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, updateData.getCourseCode());
        p.setString(2, updateData.getCourseName());
        p.setString(3, updateData.getStudentID());
        p.setString(4, updateData.getStudentName());
        p.setString(5, updateData.getQuizName());
        p.setString(6, updateData.getQuizResult());
        p.setString(7, updateData.getQuizTotal());
        p.setString(8, updateData.getQuizStatus());
        p.setInt(9, idquizes);
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data updated Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "Failed to update data.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Updating data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }
 public void updateStudentExamToDatabase(ModelExam updateData, int idexams) {
    try {
       String sql = "UPDATE exams SET coursecode = ?, coursename = ?, studentID = ?, fullname = ?, examnumber = ?, examresult = ?, examtotal = ?, status = ? WHERE idexams = ?";
        
        
        p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, updateData.getCourseCode());
        p.setString(2, updateData.getCourseName());
        p.setString(3, updateData.getStudentID());
        p.setString(4, updateData.getStudentName());
        p.setString(5, updateData.getExamName());
        p.setString(6, updateData.getExamResult());
        p.setString(7, updateData.getExamTotal());
        p.setString(8, updateData.getExamStatus());
        p.setInt(9, idexams);
        int rowsAffected = p.executeUpdate();
        if(rowsAffected > 0)
        {
            JOptionPane.showMessageDialog(null, "Data updated Succesfully");
        }else{
            JOptionPane.showMessageDialog(null, "Failed to update data.");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error Updating data:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }finally{
        try {
            if (p !=null) p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }
}
    

