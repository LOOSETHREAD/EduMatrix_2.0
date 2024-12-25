package Data.Models;
public class ModelFacultyUser {

    public String getTeacherid() {
        return teacherid;
    }
    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
    public String getUserName() {
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public char[] getPassword() {
        return password;
    }
    public void setPassword(char[] password) {
        this.password = password;
    }
    public ModelFacultyUser(String fullname, String username, char[] password, String teacherid) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.teacherid = teacherid;
    }
    public enum UserRole {
        ADMIN
    }
    private String fullname;
    private String username;
    private char[] password;
    private UserRole role;
    private String teacherid;
}