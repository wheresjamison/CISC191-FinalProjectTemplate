import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;

public class IOTest2 {
    public static void main(String[] args) {
        try{
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("C:\\Users\\legas\\Desktop\\march java project test\\Output2.txt"));
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\legas\\Desktop\\march java project test\\Output.txt"));
            String s;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
            br.close();
            bw.close();
        }catch(Exception ex){
            return;
        }
    }
}
