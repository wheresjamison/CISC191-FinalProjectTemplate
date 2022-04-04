import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends User implements edu{
    double GPA;
    List<String> teacherName = new ArrayList<>();
    String schoolName;
    String schoolYear;

    char[] possibleGrades = {'A','B','C', 'D','F'};
    char[] usersGrades = new char[4];

    public void assignGradesRandomly(){
        for(int j = 0; j<4; j++){
            Random random = new Random();
            int r = random.nextInt((6-0)-1);
            usersGrades[j] = possibleGrades[r];
            System.out.println("Your grade in " + courses.get(j) + " is a " + usersGrades[j]);
            userBasicInfo.add("Your grade in " + courses.get(j)+ " is a " +usersGrades[j] +newLine);
        }
    }

    public void calculateGPA(){
        int g = 0;
        for(int L = 0; L<4; L++) {
            if (usersGrades[L] == 'A') {
                g = g + 4;
            }
            if (usersGrades[L] == 'B') {
                g = g + 3;
            }
            if (usersGrades[L] == 'C') {
                g = g + 2;
            }
            if (usersGrades[L] == 'D') {
                g = g + 1;
            }
            if (usersGrades[L] == 'F') {
                g = g + 0;
            }
        }
        GPA = g/4;
        System.out.println("Your current GPA is : "+ GPA);
        userBasicInfo.add(firstName + "'s GPA is : "+ GPA + newLine);
    }

    public void printTeachers(){
        System.out.println("Teachers: "+ teacherName);
    }
    public void printGPA(){
        System.out.println("Student's GPA : " + GPA);
    }

    public void setSUserInfo(){
        addLine();
        userBasicInfo.add("Student Info" + newLine);
        addLine();
        userBasicInfo.add("User ID: " + s+newLine);
        userBasicInfo.add("School: " + schoolName+newLine);
        userBasicInfo.add("Teacher's names: " + teacherName +newLine);
        userBasicInfo.add("Courses: " + courses+newLine);
        userBasicInfo.add("School year: "+ schoolYear +newLine);
        addLine();
        userBasicInfo.add("Grades: " + newLine);
        addLine();
        assignGradesRandomly();
        calculateGPA();
    }

    public void printStudentInfo(){
        line();
        System.out.println("Student Info");
        line();
        getEduAccount();
        getSchoolName();
        System.out.println("Teacher's names: " + teacherName);
        printCourses();
        printTotalCourses();
        //create a system where when the server connects the grades are updated for each student randomly
        System.out.println("School year: "+ schoolYear);
        line();
        System.out.println("Grades");
        line();
        assignGradesRandomly();
        calculateGPA();
    }

    public void printTotalCourses(){
        int totalCourses = courses.size();
        if(totalCourses == 0){
            System.out.println("User is not taking any courses");
        }
        if(totalCourses == 1){
            System.out.println("User is taking 1 course");
        } else {
            System.out.println("User is taking " + totalCourses + " courses");
        }
    }

    public void setUser(){
        typeUser = "student";
    }

    public String setEduID(){
        s = firstName.charAt(0)+lastName+"_Student_"+schoolName;
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
        schoolName = placeHolder;
        return schoolName;
    }

    @Override
    public void getSchoolName() {
       System.out.println("School : " + this.schoolName);
    }

    @Override
    public void addCourse(String course){
        courses.add(course);
    }

    @Override
    public void printCourses() {
        System.out.println("Courses : "+ courses);
    }
}
