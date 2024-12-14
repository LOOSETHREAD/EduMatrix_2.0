/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data.Models;

/**
 *
 * @author User
 */
public class ModelStudentToCourse {

    /**
     * @return the studentspr
     */
    public String getStudentspr() {
        return studentspr;
    }

    /**
     * @param studentspr the studentspr to set
     */
    public void setStudentspr(String studentspr) {
        this.studentspr = studentspr;
    }

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentStats() {
        return studentStats;
    }

    /**
     * @param studentStats the studentStats to set
     */
    public void setStudentStats(String studentStats) {
        this.studentStats = studentStats;
    }

    public String getStatussp() {
        return statussp;
    }

    /**
     * @param statussp the statussp to set
     */
    public void setStatussp(String statussp) {
        this.statussp = statussp;
    }

    public ModelStudentToCourse(String courseName, String courseCode, String studentName, String studentID, String studentStats, String studentspr, String statussp) {
        this.courseCode  = courseCode;
        this.courseName = courseName;
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentStats = studentStats;
        this.studentspr = studentspr;
        this.statussp = statussp;
        
        
    }

    public ModelStudentToCourse(String studentID, String courseCode, String courseName, String studentspr, String statussp) {
        this.studentID = studentID;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.studentspr = studentspr;
        this.statussp = statussp;
    }

    public ModelStudentToCourse(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
    
    private String courseCode;
    private String courseName;
    private String studentName;
    private String studentID;
    private String studentStats;
    private String studentspr;
    private String statussp;
}
