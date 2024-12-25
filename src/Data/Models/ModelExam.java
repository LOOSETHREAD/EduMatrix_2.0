package Data.Models;
public class ModelExam {
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
    public String getExamName() {
        return examName;
    }
    public void setExamName(String examName) {
        this.examName = examName;
    }
    public String getExamResult() {
        return examResult;
    }
    public void setExamResult(String examResult) {
        this.examResult = examResult;
    }
    public String getExamTotal() {
        return examTotal;
    }
    public void setExamTotal(String examTotal) {
        this.examTotal = examTotal;
    }
    public String getExamStatus() {
        return examStatus;
    }
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
