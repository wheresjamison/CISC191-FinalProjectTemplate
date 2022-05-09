import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

public class Personal extends User {

    static boolean privacyStatus; //true = public, false = private

    static void privacyToggle(){
        if(!privacyStatus){
            //hide from list of users

            //increments thru list of users and removes it from the list
        }
    }

    static void createUserPersonal(boolean privacy){
        privacyStatus = privacy;
        if(privacyStatus) {
            userInfo[iTotal][12] = "public";
        } else {
            userInfo[iTotal][12] = "private";
        }
        System.out.println(Arrays.deepToString(userInfo));
        createPersonalUserFile(userInfo[iTotal][0]);
    }

    static void createPersonalUserFile(String userName){
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
