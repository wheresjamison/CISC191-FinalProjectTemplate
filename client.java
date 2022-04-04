import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("LocalHost",4999);

        //i realized i needed to create an array list of users to have this work
        //the reason i was getting 120 for size was because all of this information was being pulled from the user class
        //like as master storage, this User object should be considered an admin

        ArrayList<User> allUsers = new ArrayList<User>();

        //lets create some test users.
        Student s1 = new Student();
        allUsers.add(s1);
        s1.firstName = "Jamison";
        s1.lastName = "Legaspi";
        s1.schoolName = "Mesa";
        s1.age = 21;
        s1.birthDay = 13;
        s1.birthYear = 2001;
        s1.birthMonth(2);
        s1.email = "jamison@jamison.com";
        s1.phoneNumber = "123-123-1234";
        s1.setEduID();
        s1.addCourse("Nutrition 153");
        s1.addCourse("Math 151");
        s1.addCourse("Architecture 127");
        s1.addCourse("CISC 191");
        s1.setBasicUserInfo();
        s1.setSUserInfo();
        Student s2 = new Student();
        allUsers.add(s2);
        s2.firstName = "Sepehr";
        s2.lastName = "Yari";
        s2.schoolName = "Mesa";
        s2.age = 22;
        s2.birthDay = 23;
        s2.birthYear = 1999;
        s2.birthMonth(11);
        s2.email = "arya@arya.com";
        s2.phoneNumber = "123-123-1111";
        s2.setEduID();
        s2.addCourse("ART 100");
        s2.addCourse("Nutrition 153");
        s2.addCourse("ArtF 120");
        s2.addCourse("English 100");
        s2.setBasicUserInfo();
        s2.setSUserInfo();
        Teacher t1 = new Teacher();
        allUsers.add(t1);
        t1.firstName = "Jose";
        t1.lastName = "Sierra";
        t1.schoolName = "OmegaAcademy";
        t1.setEduID();
        t1.addCourse("NUTR 152");
        t1.addCourse("NUTR 153");
        t1.setExperience("4 years");
        t1.setPurpose("Teach good nutrition habbits and world views on nutrition");
        t1.setIntendedUse("Communicate effectively with students on online format");
        t1.setBasicUserInfo();
        t1.setTUserInfo();

        System.out.println("number of info for s1." + s1.userBasicInfo.size());

        Business b = new Business();
        allUsers.add(b);
        b.firstName = "Joshua";
        b.lastName = "Labaco";
        b.companyName = "LabacosTacos";
        b.setBID();
        b.companyTitle = "Owner";
        b.setPurpose("Grow business's reach");
        b.setIntendedUse("Create community behind taco shop");
        b.setBasicUserInfo();
        b.setBUserInfo();
        Personal p = new Personal();
        allUsers.add(p);
        p.firstName = "Darien";
        p.lastName = "Joseph";
        p.address = "123 Darien House apt 123";
        p.favoriteColor = "Blue";
        p.setExperience("No experience at all");
        p.setPID();
        p.setPurpose("Gain new skills to expand skillset");
        p.setIntendedUse("Learning");
        p.setBasicUserInfo();
        p.setPUserInfo();

        System.out.println("number of info for s1." + s1.userBasicInfo.size());

        //run server first then client to avoid errors.
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("User Files Written.");
        pr.flush();

        //create files for each user created based on userID
        ArrayList<String> myIDList = (ArrayList<String>) User.userIDs;



        try{
            String generatedFileName = "y";
            String generatedUserInfo = "x";
            for(int i = 0; i<User.userIDs.size(); i++){
                generatedFileName = User.userIDs.get(i);
                BufferedWriter bw = new BufferedWriter(
                        new FileWriter("C:\\Users\\legas\\Desktop\\march java project test\\" +generatedFileName+".txt"));

                for(int j = 0; j<User.userBasicInfo.size(); j++){
                    generatedUserInfo = User.userBasicInfo.get(j);
                    ArrayList<String> basicUserInfo = (ArrayList<String>) User.userBasicInfo;
                    bw.write(generatedUserInfo);
                }
                bw.close();
                //everything works, writes files and all that, im just having 1 small problems
                //so basically the "User.userBasicInfo.size()" is like 120 which is basically all the info for s1,s2,t1,b,p
                //because of this, it will create all the files, but write all the information for every user on each file
                //instead of separating it per file. not sure what the solution is but
                //but im pretty sure i can find it easily and fix the project. just going todo some reasarch
            }
        }catch(Exception ex){
            return;
        }
    }
}
