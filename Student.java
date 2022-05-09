import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

public class Student extends User{

    static double GPA;
    static String schoolName;

    static void calculateGPA(char g1, char g2, char g3, char g4){
        int g = 0;
        char[] listGrades = {g1,g2,g3,g4};
        for(int L = 0; L<4; L++) {
            if(listGrades[L]=='a'){
                g=g+4;
            }
            if(listGrades[L]=='b'){
                g=g+3;
            }
            if(listGrades[L]=='c'){
                g=g+2;
            }
            if(listGrades[L]=='d'){
                g=g+1;
            }
            if(listGrades[L]=='f'){
                g=g=0;
            }
        }
        GPA = g/4;
    }

    static void createUserStudent(String schoolName,
                                  String c1, String c2, String c3, String c4,
                                  String g1, String g2, String g3, String g4){

        userInfo[iTotal][12] = schoolName;
        userInfo[iTotal][13] = c1;
        userInfo[iTotal][14] = c2;
        userInfo[iTotal][15] = c3;
        userInfo[iTotal][16] = c4;
        userInfo[iTotal][17] = g1;
        userInfo[iTotal][18] = g2;
        userInfo[iTotal][19] = g3;
        userInfo[iTotal][20] = g4;

        calculateGPA(g1.charAt(0),g2.charAt(0),g3.charAt(0),g4.charAt(0));
        userInfo[iTotal][21] = String.valueOf(GPA);
        System.out.println(Arrays.deepToString(userInfo));
        totalUsersP1 = iTotal + 1;
        createUser(userInfo[iTotal][0]);
    }

    static void createUser(String userName){
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

}
