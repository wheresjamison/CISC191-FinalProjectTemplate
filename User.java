import java.beans.BeanDescriptor;
import java.util.ArrayList;
import java.util.List;

public class User {
    String firstName,lastName,email;
    int age = 0;
    private String[] birthMonthName = {"January","February",
            "March","April","May",
            "June","July","August",
            "September","October","November",
            "December"};
    int birthDay;
    int birthYear;
    String phoneNumber;
    String x; //birthMonthName
    String s; //string for userID
    String typeUser; //specifies what type of user
    String bDayString; //string of whole birthday combines (month day, year)

    static List<String> userIDs = new ArrayList<>();

    public String[] getListOfUsersIDs(){
        String[] list = null;
        for(int i = 0; i<userIDs.size(); i++){
            list[i] = userIDs.get(i);
        }
        return list;
    }

    static List<String> userBasicInfo = new ArrayList<>();

    public void addLine(){
        userBasicInfo.add(line+newLine);
    }
    //add this to the client
    public void setBasicUserInfo(){
        userBasicInfo.add("User Info" + newLine);
        addLine();
        userBasicInfo.add("First name: " + firstName + newLine);
        userBasicInfo.add("Last name: "+ lastName + newLine);
        userBasicInfo.add("Age: " + age + newLine);
        userBasicInfo.add(bDayString+newLine);
        addLine();
        userBasicInfo.add("ContactInfo"+newLine);
        addLine();
        userBasicInfo.add("Email: " + email+ newLine);
        userBasicInfo.add("Phone number: "+ phoneNumber + newLine);
    }

    String line = "------------------------------------";
    String newLine = "\n";

    public void line(){
        System.out.println(line);
    }

    public void printBasicInfo(){
        line();
        System.out.println("User Info");
        line();
        System.out.println("First name: " + firstName);
        System.out.println("Last name: "+ lastName);
        System.out.println("Age: " + age);
        printBDay();
        line();
        System.out.println("Contact info");
        line();
        System.out.println("Email: " + email);
        System.out.println("Phone number: " + phoneNumber);

    }

    public String birthMonth(int birthMonthNumber){
        x = birthMonthName[birthMonthNumber-1];
        return x;
    }

    public void setBDayString(){
        bDayString = x + " "+ birthDay + ", " + birthYear;
    }

    public void printBDay(){
        setBDayString();
        System.out.println("Birthday : "+ bDayString);
    }

    public void printBDayWithName(){
        System.out.println(firstName + "'s Birthday is: " + bDayString);
    }

    public void happyBirthday(){
        System.out.println("Happy Birthday");
    }
}

