package Data.Models;
public class ModelStudentToCourse {
    public String getStudentspr() {
        return studentspr;
    }
    public void setStudentspr(String studentspr) {
        this.studentspr = studentspr;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
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
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentStats() {
        return studentStats;
    }
    public void setStudentStats(String studentStats) {
        this.studentStats = studentStats;
    }
    public String getStatussp() {
        return statussp;
    }
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
