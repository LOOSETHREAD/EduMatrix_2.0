package Data.Models;

public class ModelFacultyUser {

    /**
     * @return the teacherid
     */
    public String getTeacherid() {
        return teacherid;
    }

    /**
     * @param teacherid the teacherid to set
     */
    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    /**
     * @return the status
     */

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the program
     */

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