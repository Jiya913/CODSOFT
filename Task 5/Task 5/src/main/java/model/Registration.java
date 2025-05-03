package model;

public class Registration {
    private String studentID;
    private String courseCode;
    
    public Registration(String studentID, String courseCode) {
        this.studentID = studentID;
        this.courseCode = courseCode;
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
}
