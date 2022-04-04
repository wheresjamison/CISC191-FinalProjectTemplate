public class Business extends User implements pro{

    String companyName = "";
    String companyTitle = "";

    String time;
    String purpose;
    String intention;


    //create if statement to see if user is business in client
    public void setBUserInfo(){
        addLine();
        userBasicInfo.add("Business account info"+newLine);
        addLine();
        setBID();
        userBasicInfo.add("User ID: " + s+newLine);
        userBasicInfo.add("Company employed: "+ companyName + newLine);
        userBasicInfo.add("Company positions: " + companyTitle + newLine);
        userBasicInfo.add("Experience: " + time + newLine);//experience
        addLine();
        userBasicInfo.add("Purpose: " + purpose + newLine);//purpose
        userBasicInfo.add("Intended use: "+ intention + newLine);//intended use
    }

    public void setUser(){
        typeUser = "business";
    }
    public String setBID(){
        s = (firstName.charAt(0)+lastName+"_Business_"+companyName);
        userIDs.add(s);
        setUser();
        return s;
    }
    public void printBusinessUserID(){
        System.out.println("Your business account name is: "+ s);
    }
    public void printBusinessInfo(){
        line();
        System.out.println("Business account info");
        line();
        setBID();
        printBusinessUserID();
        System.out.println("Company employed: " + companyName);
        System.out.println("Company position: " + companyTitle);
        getExperience();
        line();
        getPurpose();
        getIntendedUse();
    }

    @Override
    public String setExperience(String time) {
        this.time = time;
        return time;
    }

    @Override
    public void getExperience() {
        System.out.println("This users experience is: ");
        System.out.println(time);
    }

    @Override
    public String setPurpose(String purpose) {
        this.purpose = purpose;
        return purpose;
    }

    @Override
    public void getPurpose() {
        System.out.println("This users purposes is: ");
        System.out.println(purpose);
    }

    @Override
    public String setIntendedUse(String intention) {
        this.intention = intention;
        return intention;
    }

    @Override
    public void getIntendedUse() {
        System.out.println("This users purpose is: ");
        System.out.println(intention);
    }
}
