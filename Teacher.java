import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User implements  edu,pro{
    int numberOfStudents;
    List<String> studentsNames = new ArrayList<>();

    String schoolName;
    List<String> courses = new ArrayList<>();

    String time;
    String purpose;
    String intention;

    public void printTeacherInfo(){
        line();
        System.out.println("Teacher Info");
        line();
        getEduAccount();
        getSchoolName();
        printCourses();
        getExperience();
        line();
        System.out.println("Students attending");
        line();
        System.out.println("Student's Names: " + studentsNames);
        line();
        getPurpose();
        getIntendedUse();
    }

    public void setUser(){
        typeUser = "teacher";
    }

    public void setTUserInfo(){
        addLine();
        userBasicInfo.add("Teacher Info" + newLine);
        addLine();
        userBasicInfo.add("User ID: " + s+newLine);
        userBasicInfo.add("School: " + schoolName+newLine);
        userBasicInfo.add("Courses: " + courses+newLine);
        userBasicInfo.add("Experience: " + time + newLine);//experience
        addLine();
        userBasicInfo.add("Students attending"+newLine);
        addLine();
        userBasicInfo.add("Student's Names: " + studentsNames + newLine);
        addLine();
        userBasicInfo.add("Purpose: " + purpose + newLine);//purpose
        userBasicInfo.add("Intended use: "+ intention + newLine);//intended use
    }

    public String setEduID(){
        s = firstName.charAt(0)+lastName+"_Teacher_"+schoolName;
        userIDs.add(s);
        setUser();
        return s;
    }

    @Override
    public void getEduAccount() {
        System.out.println("Your account name is :" + s);
    }

    @Override
    public String setSchoolName(String placeHolder) {
        this.schoolName = placeHolder;
        return schoolName;
    }

    @Override
    public void getSchoolName() {
        System.out.println("School :" + this.schoolName);
    }

    @Override
    public void addCourse(String course){
        courses.add(course);
    }

    @Override
    public void printCourses() {
        System.out.println("Courses : "+ courses);
    }

    @Override
    public String setExperience(String time) {
        this.time=time;
        return time;
    }

    @Override
    public void getExperience() {
        System.out.print("This users experience is: ");
        System.out.println(time);
    }

    @Override
    public String setPurpose(String purpose) {
        this.purpose = purpose;
        return purpose;
    }

    @Override
    public void getPurpose() {
        System.out.print("This users purposes is: ");
        System.out.println(purpose);
    }

    @Override
    public String setIntendedUse(String intention) {
        this.intention = intention;
        return intention;
    }

    @Override
    public void getIntendedUse() {
        System.out.print("This users purpose is: ");
        System.out.println(intention);
    }
}
