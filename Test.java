import java.lang.NullPointerException;
import java.util.*;

public class Test{
    public static void line(){
        System.out.println("------------------------------------");
    }
    public static void main(String[] args){

        Student x = new Student();
        Student y = new Student();
        Teacher t = new Teacher();
        Business b = new Business();
        Personal p = new Personal();

        x.firstName = "Jamison";
        x.lastName = "Legaspi";
        x.setSchoolName("Mesa");
        x.addCourse("English");
        x.addCourse("Math");
        x.addCourse("Science");
        x.addCourse("History");
        x.age = 21;
        x.birthMonth(2);
        x.birthDay=13;
        x.birthYear=2001;
        line();
        x.teacherName.add("Joe ShMoe");
        x.teacherName.add("Joe Doe");
        x.email = "abc@abc.com";
        x.schoolYear = "Junior";
        x.phoneNumber = "123-123-1234";


        y.firstName = "Jose";
        y.lastName = "Joseph";

        t.firstName = "Joe";
        t.lastName = "Mama";
        t.age = 100;
        t.email = "Jmama@edu.edu";
        t.birthDay = 9;
        t.birthMonth(9);
        t.birthYear = 1922;
        t.phoneNumber = "123-123-1235";
        t.schoolName = "Miramar";
        t.addCourse("History");
        t.addCourse("Geography");
        t.addCourse("Government");
        t.setExperience("12 years");
        t.setPurpose("Teach students new skills");
        t.setIntendedUse("Improve students abilities");

        b.firstName = "Dan";
        b.lastName = "Dirty";
        b.age = 44;
        b.email = "DirtyDan@biz.com";
        b.phoneNumber = "123-123-1233";
        b.setExperience("10 years");
        b.setPurpose("Create work for company");
        b.setIntendedUse("Software for lobby computer");

        p.firstName = "Darien";
        p.lastName = "Josh";
        p.age = 20;
        p.email = "DarienJosh@dj.com";
        p.phoneNumber = "123-123-3213";
        p.setExperience("No Experience");
        p.setPurpose("Gain a new skill over spring break");
        p.setIntendedUse("Personal projects only");

        line();
        //list of student printer
        List<Student> allStudents = new ArrayList<Student>();
        allStudents.add(x);
        allStudents.add(y);
        Iterator itr = allStudents.iterator();

        while(itr.hasNext()){
            Student st = (Student)itr.next();
            System.out.println(st.firstName+ " "+ st.lastName + " "+ st.age);
        }
        line();

        t.numberOfStudents = allStudents.size();
        System.out.println(t.numberOfStudents);
        line();

        Iterator itr2 = allStudents.iterator();
        while(itr2.hasNext()){
            Student st2 = (Student)itr2.next();
            t.studentsNames.add(st2.firstName);
        }

        System.out.println("Teacher's students: " + t.studentsNames);

        line();
        line();
        line();
        x.printBasicInfo();
        x.printStudentInfo();

        line();
        line();
        line();
        t.printBasicInfo();
        t.printTeacherInfo();

        line();
        line();
        line();
        b.printBasicInfo();
        b.printBusinessInfo();

        line();
        line();
        line();
        p.printBasicInfo();
        p.printPersonalUserInfo();

        int xxx;
        xxx = p.userIDs.size();
        System.out.println(xxx);

    }

}
