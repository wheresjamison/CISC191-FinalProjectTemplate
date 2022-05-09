import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

public class Business extends User{

    String companyName;

    static void createUserBusiness(String companyName){
        userInfo[iTotal][12] = companyName;

        System.out.println(Arrays.deepToString(userInfo));
        createBusinessUserFile(userInfo[iTotal][0]);
    }

    static void createBusinessUserFile(String userName){
        try{
            BufferedWriter bwB = new BufferedWriter(new FileWriter("C:\\Users\\Jamison-chan\\Desktop\\aprilProjectOutput\\" + userName+".txt"));
            String write;
            for(int i = 0; i < 13; i++){
                write = userInfo[iTotal][i];
                bwB.write(write+"\n");
            }
            bwB.close();
        }catch(Exception ex){
            return;
        }
    }



    String time;
    String purpose;
    String intention;

}
