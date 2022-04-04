public class Personal extends User implements pro{

    String address = "";
    String favoriteColor = "";

    String time;
    String purpose;
    String intention;

    public void printPersonalUserInfo(){
        line();
        System.out.println("Personal account info");
        line();
        System.out.println("Address: " + address);
        System.out.println("Favorite color: "+ favoriteColor);
        getExperience();
        line();
        getPurpose();
        getIntendedUse();
    }

    public void setPUserInfo(){
        addLine();
        userBasicInfo.add("Personal account info" + newLine);
        addLine();
        userBasicInfo.add("Address: " + address + newLine);
        userBasicInfo.add("Favorite color: " + favoriteColor +newLine);
        userBasicInfo.add("Experience: " + time + newLine);//experience
        addLine();
        userBasicInfo.add("Purpose: " + purpose + newLine);//purpose
        userBasicInfo.add("Intended use: "+ intention + newLine);//intended use
    }

    public void setUser(){
        typeUser = "personal";
    }

    public String setPID(){
        s = firstName+lastName+"_Personal";
        userIDs.add(s);
        setUser();
        return s;
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
