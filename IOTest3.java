import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class IOTest3{
    public static void main(String[] args) {
        //creating 2 users

        //end of creating test users

        //this allows me to work the array from the User class and grab all the users I have entered In previously
        ArrayList<String> myIDList = (ArrayList<String>) User.userIDs;

        try{
            String generatedFileName = "y";
            for(int i = 0; i<User.userIDs.size(); i++){
                generatedFileName = User.userIDs.get(i);
                BufferedWriter bw = new BufferedWriter(
                        new FileWriter("C:\\Users\\legas\\Desktop\\march java project test\\" +generatedFileName+".txt"));
            }

        }catch(Exception ex){

        }
    }
}
