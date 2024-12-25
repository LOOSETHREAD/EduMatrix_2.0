package Data.Models;
public class ModelQuiz {
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getQuizName() {
        return quizName;
    }
    public void setQuizName(String quizNumber) {
        this.quizName = quizNumber;
    }
    public String getQuizResult() {
        return quizResult;
    }
    public void setQuizResult(String quizResult) {
        this.quizResult = quizResult;
    }
    public String getQuizTotal() {
        return quizTotal;
    }
    public void setQuizTotal(String quizTotal) {
        this.quizTotal = quizTotal;
    }
    public String getQuizStatus() {
        return quizStatus;
    }
    public void setQuizStatus(String quizStatus) {
        this.quizStatus = quizStatus;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
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
