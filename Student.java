public class Student {
    private int studentID;
    private String firstName;
    private String lastName;
    private String course;

    Student(int studentID, String firstName, String lastName, String course) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int newStudentID) {
        studentID = newStudentID;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String newCourse) {
        course = newCourse;
    }

    @Override
    public String toString() {
        return studentID +" "+ firstName +" "+ lastName +" "+ course;
    }
    
}
