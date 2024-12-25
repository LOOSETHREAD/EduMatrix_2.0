package Data.Models;
public class ModelCourse {
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
    public ModelCourse(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
    private String courseCode;
    private String courseName;
}
