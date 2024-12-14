/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data.Models;

/**
 *
 * @author User
 */
public class ModelQuiz {

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
     * @return the quizName
     */
    public String getQuizName() {
        return quizName;
    }

    /**
     * @param quizNumber the quizName to set
     */
    public void setQuizName(String quizNumber) {
        this.quizName = quizNumber;
    }

    /**
     * @return the quizResult
     */
    public String getQuizResult() {
        return quizResult;
    }

    /**
     * @param quizResult the quizResult to set
     */
    public void setQuizResult(String quizResult) {
        this.quizResult = quizResult;
    }

    /**
     * @return the quizTotal
     */
    public String getQuizTotal() {
        return quizTotal;
    }

    /**
     * @param quizTotal the quizTotal to set
     */
    public void setQuizTotal(String quizTotal) {
        this.quizTotal = quizTotal;
    }

    /**
     * @return the quizStatus
     */
    public String getQuizStatus() {
        return quizStatus;
    }

    /**
     * @param quizStatus the quizStatus to set
     */
    public void setQuizStatus(String quizStatus) {
        this.quizStatus = quizStatus;
    }

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

    public ModelQuiz(String courseCode, String courseName, String studentID, String studentName, String quizName, String quizResult, String quizTotal, String quizStatus) {
    this.courseCode = courseCode;
    this.courseName = courseName;
    this.studentID = studentID;
    this.studentName = studentName;
    this.quizName = quizName;
    this.quizResult = quizResult;
    this.quizTotal = quizTotal;
    this.quizStatus = quizStatus;
}


    public ModelQuiz(String coursecode, String courseName,String quizName) {
        this.courseCode = coursecode;
        this.courseName = courseName;
        this.quizName = quizName;
    }

    public ModelQuiz(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public ModelQuiz(String quizName) {
        this.quizName = quizName;
    }    

    public ModelQuiz(String courseCode, String courseName, String studentID, String quizName ,String quizResult, String quizTotal, String quizStatus) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.studentID = studentID;
        this.quizName = quizName;
        this.quizResult = quizResult;
        this.quizTotal = quizTotal;
        this.quizStatus = quizStatus;
    }

    
    
    
    private String courseCode;
    private String courseName;
    private String studentID;
    private String studentName;
    private String quizName;
    private String quizResult;
    private String quizTotal;
    private String quizStatus;
    
}
