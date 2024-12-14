package Data.Controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Data.Models.ModelFacultyUser;
import Data.Database.DatabaseConnection;
import Data.Models.ModelStudentUser;



public class AddUser {
    
    
    public boolean addFacultyToDatabase(ModelFacultyUser data) throws ClassNotFoundException {
    String checkSql = "SELECT COUNT(*) AS count FROM facultyuser";
    String insertSql;

    try (
        PreparedStatement checkStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(checkSql);
        ResultSet resultSet = checkStatement.executeQuery()
    ) {
        // Check the number of rows in the table
        resultSet.next();
        int rowCount = resultSet.getInt("count");

        // Determine the SQL statement based on row count
        if (rowCount == 0) {
            insertSql = "INSERT INTO facultyuser (fullname, program, username, password, role, teacherid) VALUES (?, ?, ?, ?, 'ADMIN', ?)";
        } else {
            // If more than 0 rows exist, do not allow additional users
            return false; // Indicate failure due to existing users
        }

        // Execute the INSERT query
        try (PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(insertSql)) {
            p.setString(1, data.getFullname());
            p.setString(2, data.getProgram());
            p.setString(3, data.getUserName());
            p.setString(4, new String(data.getPassword())); // Convert password char[] to String
            p.setString(5, data.getTeacherid());
            p.executeUpdate();
        }

        return true; // Indicate success
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Indicate failure due to an exception
    }
}

    public ModelFacultyUser SignInFaculty(ModelFacultyUser data) {
    try {
        // SQL query to retrieve user details, including role
        String sql = "SELECT * FROM facultyuser WHERE username = ? AND password = ?";
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, data.getUserName());
        p.setString(2, new String(data.getPassword()));
        ResultSet rs = p.executeQuery();

        if (rs.next()) {
            // Retrieve all required fields from the database
            String fullname = rs.getString("fullname");
            String program = rs.getString("program"); // Program
            String username = rs.getString("username");
            char[] password = rs.getString("password").toCharArray();
            String teacherid = rs.getString("teacherid");
            String roleString = rs.getString("role"); // Retrieve the role from DB

            // Convert the role string to the UserRole enum
            ModelFacultyUser.UserRole role = null;
            if (roleString != null) {
                role = ModelFacultyUser.UserRole.valueOf(roleString.toUpperCase());
            }

            // Create and return the ModelFacultyUser instance
            ModelFacultyUser user = new ModelFacultyUser(fullname, program, username, password, teacherid);
            user.setRole(role); // Set the role
            return user;
        } else {
            // If no matching user is found
            return null;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}


    public  boolean addStudentToDatabase(ModelStudentUser data) throws ClassNotFoundException {
    try {
        
        String checkSql = "SELECT COUNT(*) AS count FROM studentuser";
        PreparedStatement checkStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(checkSql);
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();
        int rowCount = resultSet.getInt("count");
        
        String sql;
        sql = switch (rowCount) {
            default -> "INSERT INTO studentuser (fullname, program, username, password, studentid) VALUES (?, ?, ?, ?, ?)";
        };
        
        
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, data.getFullname());
        p.setString(2, data.getProgram());
        p.setString(3, data.getUsername());
        p.setString(4, new String(data.getPassword()));
        p.setString(5, data.getStudentid());
        p.executeUpdate();
        return true; 
    } catch (SQLException e) {
        e.printStackTrace();
        return false; 
    }
    }
    public ModelStudentUser SignInStudent(ModelStudentUser data){
          try {
             
              String sql = "SELECT * FROM studentuser WHERE username LIKE ? AND password LIKE ?";
              PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
              p.setString(1, data.getUsername());
              p.setString(2, new String(data.getPassword()));
              ResultSet rs = p.executeQuery();
            if (rs.next()) {
                
                return new ModelStudentUser(rs.getString("username"), rs.getString("password").toCharArray(), rs.getString("fullname"), rs.getString("studentid"));
            } else {
                
                return null;
            }
          } catch (Exception e) {
              e.printStackTrace();
              return null;
          }
        
     
      }
   public String encryptPass(String password){
        try {
            MessageDigest digestor = MessageDigest.getInstance("SHA-256");
            byte [] encodeHash = digestor.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder encryptionValue = new StringBuilder(2 * encodeHash.length);
            
             for (int i = 0; i < encodeHash.length; i++) {
                String hexVal = Integer.toHexString(0xff & encodeHash[i]);
                if (hexVal.length() == 1) {
                    encryptionValue.append('0');
                }
                encryptionValue.append(hexVal);
            }
             return encryptionValue.toString();
        } catch (Exception e) {
             return e.getMessage();
        }
        
    
}

}
