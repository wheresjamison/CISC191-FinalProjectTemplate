import com.sun.corba.se.impl.resolver.FileResolverImpl;
import sun.awt.image.ImageWatched;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class User {

    static String firstName, lastName, email, birthDayString, typeUser, password, secretAnswer;
    static int age, birthMonthNumber, birthDay, birthYear, phoneNumber;

    static int totalUsersP1 = 1;
    static int variedVariables = 22;
    //user has 12 items, student has total of 23(including user),
    static String[][] loginInfo = new String[10][3]; //email, password, secretAnswer
    static String[][] userInfo = new String[totalUsersP1][variedVariables];

    private String[] birthMonthName = {"January","February",
            "March","April","May",
            "June","July","August",
            "September","October","November",
            "December"};

    static LinkedList<String> listOfUserNames = new LinkedList<String>();//load file info into here

    static LinkedList<String> loadedListUserNames = new LinkedList<>();
    static ArrayList<String> loadedLoginInfoPoint1 = new ArrayList<>();
    static String[][] loadedUserInfo = new String[loadedLoginInfoPoint1.size()][1];//ignore for now
    static String[][] loadedLoginInfo = new String[loadedLoginInfoPoint1.size()][3]; ;

    static String setUserName(String firstName, String lastName, String phoneNumber){
        String userName;
        String lastFourOfPhoneNumber = phoneNumber.substring(phoneNumber.length()-4);
        userName = lastName + firstName.charAt(0) + lastFourOfPhoneNumber;
        //System.out.println(userName);
        loadedListUserNames.add(userName);

        return userName;
    }

    static int iTotal = loadedListUserNames.size();

    static void addUserLoginInfo(String email, String password, String secretAnswer){
        loginInfo[iTotal][0] = email;
        loginInfo[iTotal][1] = password;
        loginInfo[iTotal][2] = secretAnswer;
        /**
        loadedLoginInfo[iTotal][0] = email;
        loadedLoginInfo[iTotal][1] = password;
        loadedLoginInfo[iTotal][2] = secretAnswer;
         */
    }

    static void createUser(String firstName, String lastName, String email,
                           String phoneNumber, String mm, String dd, String yy,
                           String age, String secretAnswer, String password, String typeUser){

        String userName = setUserName(firstName, lastName, phoneNumber);
        listOfUserNames.add(userName);
        loadedListUserNames.add(userName);
        createAllUsersFile(userName);
        addUserLoginInfo(email, password, secretAnswer);

        userInfo[iTotal][0] = userName;
        userInfo[iTotal][1] = typeUser;
        userInfo[iTotal][2] = firstName;
        userInfo[iTotal][3] = lastName;
        userInfo[iTotal][4] = email;
        userInfo[iTotal][5] = phoneNumber;
        userInfo[iTotal][6] = mm;
        userInfo[iTotal][7] = dd;
        userInfo[iTotal][8] = yy;
        userInfo[iTotal][9] = age;
        userInfo[iTotal][10] = secretAnswer;
        userInfo[iTotal][11] = password;
        addLoginInfoToFile();

        //System.out.println(Arrays.deepToString(userInfo) );
    }

    static int findUserIndex(String email){
        int i = 0;

        while(!loadedLoginInfo[i][0].equals(email)){
            i++;
        }
        return i;
    }

    static String checkPassword(String email, String enteredPassword){
        //find index of email and password
        int index = 0;
        try{
            index = findUserIndex(email);
        } catch(NullPointerException ne){
            System.out.println("User does not exist");
        }
        if(enteredPassword.equals(loadedLoginInfo[index][1])){
            return "Password Correct";
        } else{
            return "Password incorrect";
        }
    }

    static String checkAnswer(String email, String answer, String newPassword){
        int index = 0;
        try{
            index = findUserIndex(email);
        } catch(NullPointerException ne){
            System.out.println("User does not exist");
        }

        if(answer.equals(loadedLoginInfo[index][2])){
            loadedLoginInfo[index][1] = newPassword;
            return "New password has been set";
        }else{
            return "Answer is incorrect";
        }

    }

    static void createAllUsersFile(String userName){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Jamison-chan\\Desktop\\aprilProjectOutput\\allUserNames.txt",true));
            String write;
                write = userName;
                bw.write(write+"\n");
            bw.close();
            //System.out.println("Loaded list size"+ loadedListUserNames.size());
        }catch(Exception ex){
            return;
        }
    }

    static void loadUserLoginInfo(){
        //every time the program restarts it will need to load the linked list inorder to have the info to opperate
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Jamison-chan\\Desktop\\aprilProjectOutput\\loginInfo.txt"));
            Scanner scanner = new Scanner(br);
            while (scanner.hasNextLine()){
                    String readLine = scanner.nextLine();
                    loadedLoginInfoPoint1.add(readLine); // created this cuz i had error with i++ getting error
                   // System.out.println(readLine);
                   // System.out.println(loadedLoginInfoPoint1.size());
            }
            scanner.close();
        }catch(FileNotFoundException e){

        }
    }

    static void addLoginInfoToFile(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Jamison-chan\\Desktop\\aprilProjectOutput\\loginInfo.txt",true));
            String write;
            String e = userInfo[iTotal][4];
            String p = userInfo[iTotal][11];
            String sa = userInfo[iTotal][10];
            bw.write(e+"\n");
            bw.write(p+"\n");
            bw.write(sa+"\n");
            bw.close();
        }catch(Exception ex){
            return;
        }
    }

    static void loadListUserNames(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Jamison-chan\\Desktop\\aprilProjectOutput\\allUserNames.txt"));
            Scanner scanner = new Scanner(br);
            while (scanner.hasNextLine()){
                String readLine = scanner.nextLine();
                loadedListUserNames.add(readLine);
            }
            scanner.close();
            //System.out.println(loadedListUserNames);
        }catch(FileNotFoundException e){
            System.out.println("error");
        }
    }

    //sorting users's usernames alphabetically
    static ArrayList<CompareUser> userNames1 = new ArrayList<CompareUser>();

    static void uploadToUserNameList(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Jamison-chan\\Desktop\\aprilProjectOutput\\allUserNames.txt"));
            Scanner sc = new Scanner(br);
            while(sc.hasNextLine()) {
                userNames1.add(new CompareUser(sc.nextLine()));
            }
            sc.close();
        }catch(IOException e){
            System.out.println("Error");
        }
    }

    static void alphabetizeUsers(){
        System.out.println("List of users presort");
        for(int i = 0; i < userNames1.size(); i++){
            System.out.println(userNames1.get(i).getUserName());
        }
        System.out.println("--------");
        System.out.println("Sorted list of users:");
        Collections.sort(userNames1);
        for(int i = 0; i<userNames1.size();i++){
            System.out.println(userNames1.get(i).getUserName());
        }
    }

}