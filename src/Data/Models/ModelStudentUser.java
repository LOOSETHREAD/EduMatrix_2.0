package Data.Models;
public class ModelStudentUser {
    public String getStudentid() {
        return studentid;
    }
    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getProgram() {
        return program;
    }
    public void setProgram(String program) {
        this.program = program;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public char[] getPassword() {
        return password;
    }
    public void setPassword(char[] password) {
        this.password = password;
    }
    public ModelStudentUser(String fullname, String program, String username, char[] password, String studentid) {
        this.fullname = fullname;
        this.program = program;
        this.username = username;
        this.password = password;
        this.studentid = studentid;
    }
    public ModelStudentUser(String username, char[] password, String fullname,String studentid, String program) {
        this.program = program;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.studentid = studentid;
    }
    public ModelStudentUser() {
    }
    private String fullname;
    private String program;
    private String username;
    private char[] password;
    private String studentid;
}