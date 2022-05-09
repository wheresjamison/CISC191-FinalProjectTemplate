import java.io.IOException;
import java.net.*;
import java.io.*;

//run server first
public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();

        System.out.println("Client Connected");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String locationString = "C:\\Users\\legas\\Desktop\\apriljavafilefolder";

        String str = bf.readLine();
        System.out.println("Client: " + str);
        System.out.println("File written to location: "+ locationString);
    }
}
