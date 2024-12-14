/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data.Models;

/**
 *
 * @author User
 */
public class ModelExam {

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

    /**
     * @return the examName
     */
    public String getExamName() {
        return examName;
    }

    /**
     * @param examName the examName to set
     */
    public void setExamName(String examName) {
        this.examName = examName;
    }

    /**
     * @return the examResult
     */
    public String getExamResult() {
        return examResult;
    }

    /**
     * @param examResult the examResult to set
     */
    public void setExamResult(String examResult) {
        this.examResult = examResult;
    }

    /**
     * @return the examTotal
     */
    public String getExamTotal() {
        return examTotal;
    }

    /**
     * @param examTotal the examTotal to set
     */
    public void setExamTotal(String examTotal) {
        this.examTotal = examTotal;
    }

    /**
     * @return the examStatus
     */
    public String getExamStatus() {
        return examStatus;
    }

    /**
     * @param examStatus the examStatus to set
     */
    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }

    public ModelExam(String courseCode, String courseName, String studentID, String studentName, String examName, String examResult, String examTotal, String examStatus) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.studentID = studentID;
        this.studentName = studentName;
        this.examName = examName;
        this.examResult = examResult;
        this.examTotal = examTotal;
        this.examStatus = examStatus;
        
    }

    public ModelExam(String courseCode, String courseName, String examName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.examName = examName;
    }

    public ModelExam(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public ModelExam(String courseCode, String courseName, String studentID, String examName, String examResult, String examTotal, String examStatus) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.studentID = studentID; 
        this.examName = examName;
        this.examResult = examResult;
        this.examTotal = examTotal;
        this.examStatus = examStatus;
    }
    
    
    private String courseCode;
    private String courseName;
    private String studentID;
    private String studentName;
    private String examName;
    private String examResult;
    private String examTotal;
    private String examStatus;
}
