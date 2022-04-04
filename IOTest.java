import java.io.*;
import java.nio.Buffer;

public class IOTest {
    public static void main(String[] args) {

        try{
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("C:\\Users\\legas\\Desktop\\march java project test\\Output.txt"));
                bw.write("Karen\n");
                bw.write("Chad\n");
                bw.write("Becky\n");
                bw.close();
        }catch(Exception e){
            return;
        }

    }
}
