import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Teacher extends User{

    int numberOfStudents;
    ArrayList<String> studentsNames = new ArrayList<>();

    String schoolName;
    ArrayList<String> course = new ArrayList<>();

    static void createUserTeacher(String schoolName){
        userInfo[iTotal][12] = schoolName;

        System.out.println(Arrays.deepToString(userInfo));
        createTeacherFile(userInfo[iTotal][0]);
    }
    static void createTeacherFile(String userName){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Jamison-chan\\Desktop\\aprilProjectOutput\\" + userName+".txt"));
            String write;
            for(int i = 0; i < 13; i++){
                write = userInfo[iTotal][i];
                bw.write(write+"\n");
            }
            bw.close();
        }catch(Exception ex){
            return;
        }
    }

    String time;
    String purpose;
    String intention;

}
