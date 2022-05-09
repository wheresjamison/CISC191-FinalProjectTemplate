import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class LoginPage{

    //login panel
    private static JPanel loginPanel;
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JTextField passwordText;
    private static JButton loginButton;
    private static JLabel success;
    private static JButton newUserButton;
    private static JButton forgotPasswordButton;

    //forgot password panel
    private static JPanel forgotPasswordPanel;
    private static JLabel whatIsYourEmailPanel;
    private static JTextField whatEmailText;
    private static JLabel secretQuestion;
    private static JTextField secretAnswer;
    private static JLabel newPasswordLabel;
    private static JTextField newPasswordText;
    private static JButton passwordDoneButton;
    private static JLabel statusNewPasswordLabel;

    //new user panel
    private static JPanel newUserPanel;
    private static JLabel selectUserTypeLabel;
    private static JButton studentUserButton,teacherUserButton,businessUserButton,personalUserButton;

    //user stuff
    private static JLabel firstNameLabel;
    private static JTextField firstNameText;
    private static JLabel lastNameLabel;
    private static JTextField lastNameText;
    private static JLabel emailLabel;
    private static JTextField emailText;
    private static JLabel secretQuestionLabel;
    private static JTextField secretAnswerText;
    private static JLabel ageLabel;
    private static JTextField ageText;
    private static JLabel mmddyyLabel;
    private static JTextField mmText, ddText, yyText;
    private static JLabel phoneNumberLabel;
    private static JTextField phoneNumberText;

    //forgot to add password
    private static JLabel passwordCreateLabel;
    private static JTextField passwordCreateText;

    //user type panels

    private static JLabel schoolNameLabel;
    private static JTextField schoolNameText;

    private static JPanel newStudentPanel;
    private static JLabel studentPanelTitle;

    private static JLabel course1Label, course2Label, course3Label, course4Label;
    private static JTextField course1Text, course2Text, course3Text, course4Text;
    private static JTextField course1GradeText, course2GradeText, course3GradeText, course4GradeText;
    private static JLabel yearLabel;
    private static JTextField yearText;

    private static JPanel newTeacherPanel;
    private static JLabel teacherPanelTitle;
    private static JLabel numberOfStudentsLabel;
    private static JTextField numberOfStudentsText;

    private static JPanel newBusinessPanel;
    private static JLabel businessPanelTitle;
    private static JLabel companyNameLabel;
    private static JTextField companyNameText;

    private static JPanel newPersonalPanel;
    private static JLabel personalPanelTitle;
    private static JButton privacyButton;
    static boolean privacyToggle = true;

    //
    //this is where I am leaving off, I finished created a create user button for each user depending on what is input
    //start implementing the directory once u log in.
    //once logged in, you can change pages to see user ranking
    //ranking will be by gpa for students, other wise the will be a list of users based alphabetically
    //there should also be a birthdya sorthing system (merge sorting)
    //server will calculate gpa and other things
    //

    private static JButton createNewUserButton;

    //once you log in, you can access the directory
    private static JPanel directoryPanel;
    private static JPanel userInfoPanel;
    private static JPanel rankingPanel;

    private static JButton globalBackButton;

    private static String currentPage;
    private static String typeUser;

    public static void main(String[] args) throws IOException {
        //creating an i/o stream and client server interaction
        /**
        Socket s = new Socket("LocalHost",4999);

        //loading array with list of users since only one user can be created per instance
        BufferedReader brLoadingArray = null;
        String line;

        try{
            brLoadingArray = new BufferedReader(new FileReader("C:\\Users\\legas\\Desktop\\apriljavafilefolder\\projectInfo.txt"));
            while((line = brLoadingArray.readLine()) != null){
                User.listOfUserNames.add(line);
            }
        }catch(IOException e){
            return;
        }
         */

        //creating admin user:
        User.loginInfo[0][0] = "admin";
        User.loginInfo[0][1] = "admin";
        User.loginInfo[0][2] = "admin";

        //this here will sort out the already existing users alphabetically in the console
        User.uploadToUserNameList();
        User.alphabetizeUsers();

        User.loadListUserNames();
        User.loadUserLoginInfo();

        //creating an admin user

        JFrame frame = new JFrame();
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frameForgotPassword = new JFrame();
        frameForgotPassword.setSize(300,400);
        frameForgotPassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frameNewUser = new JFrame();
        frameNewUser.setSize(300,400);
        frameNewUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        forgotPasswordPanel = new JPanel();
        frameForgotPassword.add(forgotPasswordPanel);
        forgotPasswordPanel.setLayout(null);

        loginPanel = new JPanel();
        frame.add(loginPanel);
        loginPanel.setLayout(null);

        newUserPanel = new JPanel();
        frameNewUser.add(newUserPanel);
        newUserPanel.setLayout(null);

        //setup frames and panels for each user type
        JFrame frameCreateStudent = new JFrame();
        JFrame frameCreateTeacher = new JFrame();
        JFrame frameCreateBusiness = new JFrame();
        JFrame frameCreatePersonal = new JFrame();

        frameCreateStudent.setSize(300,700);
        frameCreateTeacher.setSize(300,400);
        frameCreateBusiness.setSize(300,400);
        frameCreatePersonal.setSize(300,400);
        frameCreateStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCreateTeacher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCreateBusiness.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCreatePersonal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        newStudentPanel = new JPanel();
        newTeacherPanel = new JPanel();
        newBusinessPanel = new JPanel();
        newPersonalPanel = new JPanel();

        frameCreateStudent.add(newStudentPanel);
        newStudentPanel.setLayout(null);
        frameCreateTeacher.add(newTeacherPanel);
        newTeacherPanel.setLayout(null);
        frameCreateBusiness.add(newBusinessPanel);
        newBusinessPanel.setLayout(null);
        frameCreatePersonal.add(newPersonalPanel);
        newPersonalPanel.setLayout(null);

        //user
        firstNameLabel = new JLabel("First name:");
        firstNameLabel.setBounds(10,40,80,25);
        firstNameText = new JTextField(20);
        firstNameText.setBounds(90,40,80,25);

        lastNameLabel = new JLabel("Last name:");
        lastNameLabel.setBounds(10,70,80,25);
        lastNameText = new JTextField(20);
        lastNameText.setBounds(90,70,80,25);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10,100,80,25);
        emailText = new JTextField(20);
        emailText.setBounds(90,100,80,25);

        secretQuestionLabel = new JLabel("What is your favorite Color?");
        secretQuestionLabel.setBounds(10,130,180,25);
        secretAnswerText = new JTextField(20);
        secretAnswerText.setBounds(180,130,80,25);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(10,160,80,25);
        ageText = new JTextField(20);
        ageText.setBounds(90,160,80,25);

        mmddyyLabel = new JLabel("mm/dd/yy:");
        mmddyyLabel.setBounds(10,190,80,25);
        mmText = new JTextField(20);
        mmText.setBounds(10,220,30,25);
        ddText = new JTextField(20);
        ddText.setBounds(40,220,30,25);
        yyText = new JTextField(20);
        yyText.setBounds(70,220,30,25);

        phoneNumberLabel = new JLabel("Phone number");
        phoneNumberLabel.setBounds(10,250,100,25);
        phoneNumberText = new JTextField(20);
        phoneNumberText.setBounds(100,250,80,25);

        passwordCreateLabel = new JLabel("Set password");
        passwordCreateLabel.setBounds(10,280,100,25);
        passwordCreateText = new JTextField(20);
        passwordCreateText.setBounds(100,280,100,25);

        //login page
        ActionListener forgotPasswordListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("forgot password clicked");
                //find a way to change panel.
                frameForgotPassword.setVisible(true);
                frame.setVisible(false);
                currentPage = "forgot pw";
            }
        };

        ActionListener loginButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("login button clicked");
                String email = userText.getText();
                String password = passwordText.getText();
                success.setText(User.checkPassword(email,password));
                if(success.getText() == "Password Correct"){
                    //change panel to logged in
                }
            }
        };

        ActionListener newUserListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("new user button clicked");
                frameNewUser.setVisible(true);
                frame.setVisible(false);
            }
        };

        userLabel = new JLabel("Email");
        userLabel.setBounds(10, 20, 165, 25  );
        loginPanel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(10,50,165,25);
        loginPanel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,80,165,25);
        loginPanel.add(passwordLabel);

        passwordText = new JTextField(20);
        passwordText.setBounds(10,110,165,25);
        loginPanel.add(passwordText);

        forgotPasswordButton = new JButton("forgot password");
        forgotPasswordButton.setBounds(10,140,165,15);
        forgotPasswordButton.addActionListener(forgotPasswordListener);
        loginPanel.add(forgotPasswordButton);

        newUserButton = new JButton("Create Account");
        newUserButton.setBounds(10,160,165,15);
        newUserButton.addActionListener(newUserListener);
        loginPanel.add(newUserButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(10,180,80,25);
        loginButton.addActionListener(loginButtonListener);
        loginPanel.add(loginButton);

        success = new JLabel("");
        success.setBounds(10,200,300,25);
        loginPanel.add(success);

        //forgot password
        ActionListener passwordDoneListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = whatEmailText.getText();
                String answer = secretAnswer.getText();
                String password = newPasswordText.getText();

                System.out.println("Done Button Clicked");
                //check answer to change password
                String resultNewPassword = User.checkAnswer(email,answer,password);

                statusNewPasswordLabel.setText(resultNewPassword);

                System.out.println(resultNewPassword);

                if(resultNewPassword == "New password has been set"){
                    frameForgotPassword.setVisible(false);
                }
            }
        };

        whatIsYourEmailPanel = new JLabel("What is your email?");
        whatIsYourEmailPanel.setBounds(10,20,165,25);
        forgotPasswordPanel.add(whatIsYourEmailPanel);

        whatEmailText = new JTextField(20);
        whatEmailText.setBounds(10,50,165,25);
        forgotPasswordPanel.add(whatEmailText);

        secretQuestion = new JLabel("What is your favorite color?");
        secretQuestion.setBounds(10,80,165,25);
        forgotPasswordPanel.add(secretQuestion);

        secretAnswer = new JTextField(20);
        secretAnswer.setBounds(10,110,165,25);
        forgotPasswordPanel.add(secretAnswer);

        newPasswordLabel = new JLabel("Create a new Password");
        newPasswordLabel.setBounds(10,140,165,25);
        forgotPasswordPanel.add(newPasswordLabel);

        newPasswordText = new JTextField(20);
        newPasswordText.setBounds(10,170,165,25);
        forgotPasswordPanel.add(newPasswordText);

        statusNewPasswordLabel = new JLabel("");
        statusNewPasswordLabel.setBounds(10,170,165,25);
        forgotPasswordPanel.add(statusNewPasswordLabel);

        passwordDoneButton = new JButton("Done");
        passwordDoneButton.setBounds(10,200,80,25);
        passwordDoneButton.addActionListener(passwordDoneListener);
        forgotPasswordPanel.add(passwordDoneButton);

        //new user
        selectUserTypeLabel = new JLabel("Select your user type below: ");
        selectUserTypeLabel.setBounds(10,20,165,25);
        newUserPanel.add(selectUserTypeLabel);

        ActionListener studentAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCreateStudent.setVisible(true);
                newStudentPanel.add(firstNameLabel); newStudentPanel.add(firstNameText);
                newStudentPanel.add(lastNameLabel); newStudentPanel.add(lastNameText);
                newStudentPanel.add(emailLabel); newStudentPanel.add(emailText);
                newStudentPanel.add(secretQuestionLabel); newStudentPanel.add(secretAnswerText);
                newStudentPanel.add(ageLabel); newStudentPanel.add(ageText);
                newStudentPanel.add(mmddyyLabel);
                newStudentPanel.add(mmText); newStudentPanel.add(ddText); newStudentPanel.add(yyText);
                newStudentPanel.add(phoneNumberLabel); newStudentPanel.add(phoneNumberText);
                newStudentPanel.add(schoolNameLabel); newStudentPanel.add(schoolNameText);
                newStudentPanel.add(passwordCreateLabel); newStudentPanel.add(passwordCreateText);

                newStudentPanel.add(createNewUserButton);

                typeUser = "Student";

            }
        };

        ActionListener teacherAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frameCreateTeacher.setVisible(true);

                newTeacherPanel.add(firstNameLabel); newTeacherPanel.add(firstNameText);
                newTeacherPanel.add(lastNameLabel); newTeacherPanel.add(lastNameText);
                newTeacherPanel.add(emailLabel); newTeacherPanel.add(emailText);
                newTeacherPanel.add(secretQuestionLabel); newTeacherPanel.add(secretAnswerText);
                newTeacherPanel.add(ageLabel); newTeacherPanel.add(ageText);
                newTeacherPanel.add(mmddyyLabel);
                newTeacherPanel.add(mmText); newTeacherPanel.add(ddText); newTeacherPanel.add(yyText);
                newTeacherPanel.add(phoneNumberLabel); newTeacherPanel.add(phoneNumberText);
                newTeacherPanel.add(schoolNameLabel); newTeacherPanel.add(schoolNameText);
                newTeacherPanel.add(passwordCreateLabel);newTeacherPanel.add(passwordCreateText);

                newTeacherPanel.add(createNewUserButton);

                typeUser = "Teacher";
            }
        };

        ActionListener businessAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCreateBusiness.setVisible(true);

                newBusinessPanel.add(firstNameLabel); newBusinessPanel.add(firstNameText);
                newBusinessPanel.add(lastNameLabel); newBusinessPanel.add(lastNameText);
                newBusinessPanel.add(emailLabel); newBusinessPanel.add(emailText);
                newBusinessPanel.add(secretQuestionLabel); newBusinessPanel.add(secretAnswerText);
                newBusinessPanel.add(ageLabel); newBusinessPanel.add(ageText);
                newBusinessPanel.add(mmddyyLabel);
                newBusinessPanel.add(mmText); newBusinessPanel.add(ddText); newBusinessPanel.add(yyText);
                newBusinessPanel.add(phoneNumberLabel); newBusinessPanel.add(phoneNumberText);
                newBusinessPanel.add(passwordCreateLabel);newBusinessPanel.add(passwordCreateText);

                newBusinessPanel.add(createNewUserButton);

                typeUser = "Business";
            }
        };

        ActionListener personalAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCreatePersonal.setVisible(true);

                newPersonalPanel.add(firstNameLabel); newPersonalPanel.add(firstNameText);
                newPersonalPanel.add(lastNameLabel); newPersonalPanel.add(lastNameText);
                newPersonalPanel.add(emailLabel); newPersonalPanel.add(emailText);
                newPersonalPanel.add(secretQuestionLabel); newPersonalPanel.add(secretAnswerText);
                newPersonalPanel.add(ageLabel); newPersonalPanel.add(ageText);
                newPersonalPanel.add(mmddyyLabel);
                newPersonalPanel.add(mmText); newPersonalPanel.add(ddText); newPersonalPanel.add(yyText);
                newPersonalPanel.add(phoneNumberLabel); newPersonalPanel.add(phoneNumberText);
                newPersonalPanel.add(passwordCreateLabel); newPersonalPanel.add(passwordCreateText);

                newPersonalPanel.add(createNewUserButton);

                typeUser = "Personal";

            }
        };

        studentUserButton = new JButton("Student");
        studentUserButton.setBounds(10,50,100,25);
        studentUserButton.addActionListener(studentAction);
        newUserPanel.add(studentUserButton);

        teacherUserButton = new JButton("Teacher");
        teacherUserButton.setBounds(140,50,100,25);
        teacherUserButton.addActionListener(teacherAction);
        newUserPanel.add(teacherUserButton);

        businessUserButton = new JButton("Business");
        businessUserButton.setBounds(10,80,100,25);
        businessUserButton.addActionListener(businessAction);
        newUserPanel.add(businessUserButton);

        personalUserButton = new JButton("Personal");
        personalUserButton.setBounds(140,80,100,25);
        personalUserButton.addActionListener(personalAction);
        newUserPanel.add(personalUserButton);

        //frame for user types
        //edu
        schoolNameLabel = new JLabel("School: ");
        schoolNameText = new JTextField(20);
        schoolNameLabel.setBounds(10,310,80,25);
        schoolNameText.setBounds(90,310,80,25);

        //new student
        studentPanelTitle = new JLabel("Welcome New Student!");
        studentPanelTitle.setBounds(10,10,160,25);
        newStudentPanel.add(studentPanelTitle);

        /**
        yearLabel = new JLabel("Year: ");
        yearText = new JTextField();
        yearLabel.setBounds(10,310,80,25);
        yearText.setBounds(90,310,80,25);
        newStudentPanel.add(yearText); newStudentPanel.add(yearLabel);
        */

        JLabel coursesLabel = new JLabel("                     :  Course Names  :  Grades :");
        coursesLabel.setBounds(10,340,300,25);
        newStudentPanel.add(coursesLabel);

        course1Label = new JLabel("Course 1:");
        course2Label = new JLabel("Course 2:");
        course3Label = new JLabel("Course 3:");
        course4Label = new JLabel("Course 4:");
        course1Text = new JTextField(40);
        course2Text = new JTextField(40);
        course3Text = new JTextField(40);
        course4Text = new JTextField(40);
        course1GradeText = new JTextField(30);
        course2GradeText = new JTextField(30);
        course3GradeText = new JTextField(30);
        course4GradeText = new JTextField(30);

        //add 60 to the y
        course1Label.setBounds(10,370,80,25);
        course2Label.setBounds(10,400,80,25);
        course3Label.setBounds(10,430,80,25);
        course4Label.setBounds(10,460,80,25);
        course1Text.setBounds(90,370,80,25);
        course2Text.setBounds(90,400,80,25);
        course3Text.setBounds(90,430,80,25);
        course4Text.setBounds(90,460,80,25);
        course1GradeText.setBounds(180,370,30,25);
        course2GradeText.setBounds(180,400,30,25);
        course3GradeText.setBounds(180,430,30,25);
        course4GradeText.setBounds(180,460,30,25);

        newStudentPanel.add(course1Label);
        newStudentPanel.add(course2Label);
        newStudentPanel.add(course3Label);
        newStudentPanel.add(course4Label);
        newStudentPanel.add(course1Text);
        newStudentPanel.add(course2Text);
        newStudentPanel.add(course3Text);
        newStudentPanel.add(course4Text);
        newStudentPanel.add(course1GradeText);
        newStudentPanel.add(course2GradeText);
        newStudentPanel.add(course3GradeText);
        newStudentPanel.add(course4GradeText);

        /**
         * create user button for student
         */

        //new teacher
        teacherPanelTitle = new JLabel("Welcome new Teacher!");
        teacherPanelTitle.setBounds(10,10,160,25);
        newTeacherPanel.add(teacherPanelTitle);

        //new business person
        businessPanelTitle = new JLabel("Welcome new Business user!");
        businessPanelTitle.setBounds(10,10,160,25);
        newBusinessPanel.add(businessPanelTitle);

        //280, just changed to 310
        companyNameLabel = new JLabel("Company: ");
        companyNameText = new JTextField(20);
        companyNameLabel.setBounds(10,310,80,25);
        companyNameText.setBounds(90,310,80,25);
        newBusinessPanel.add(companyNameLabel);
        newBusinessPanel.add(companyNameText);

        //new personal user

        ActionListener privacyListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(privacyToggle==true){
                    privacyToggle = false;
                    privacyButton.setText("Private");
                } else {
                    privacyToggle = true;
                    privacyButton.setText("Public");
                }
            }
        };

        personalPanelTitle = new JLabel("Welcome new User!");
        personalPanelTitle.setBounds(10,10,165,25);
        newPersonalPanel.add(personalPanelTitle);
        privacyButton = new JButton("Public");
        privacyButton.setBounds(10,310,80,25);
        privacyButton.addActionListener(privacyListener);
        newPersonalPanel.add(privacyButton);



        directoryPanel = new JPanel();
        userInfoPanel = new JPanel();
        rankingPanel = new JPanel();

        //create user button.

        ActionListener createUserListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fn,ln, em, pn, mm, dd, yy, age, sa, pw, tu;
                fn = firstNameText.getText();
                ln = lastNameText.getText();
                em = emailText.getText();
                pn = phoneNumberText.getText();
                mm = mmText.getText();
                dd = ddText.getText();
                yy = yyText.getText();
                age = ageText.getText();
                sa = secretAnswerText.getText();
                pw = passwordCreateText.getText();
                tu = typeUser;

                User.createUser(fn,ln,em,pn,mm,dd,yy,age,sa,pw,tu);

                if(typeUser == "Student"){
                    //save user information in to a 2 dimensional array
                    //userinfo[i][j] i will be the user index, and j will contain all the information in a list
                    //logininfo[i][j] i is user index, j will be user, password, secret info
                    Student.variedVariables=23;
                    String sn,c1,c2,c3,c4,g1,g2,g3,g4;
                    sn = schoolNameText.getText();
                    c1 = course1Text.getText();
                    c2 = course2Text.getText();
                    c3 = course3Text.getText();
                    c4 = course4Text.getText();
                    g1 = course1GradeText.getText();
                    g2 = course2GradeText.getText();
                    g3 = course1GradeText.getText();
                    g4 = course4GradeText.getText();

                    Student.createUserStudent(sn,
                            c1,c2,c3,c4,
                            g1,g2,g3,g4);
                }
                if(typeUser == "Teacher"){
                    String schoolName = schoolNameText.getText();
                    Teacher.createUserTeacher(schoolName);

                }
                if(typeUser == "Business"){
                    String company = companyNameText.getText();
                    Business.createUserBusiness(company);
                }
                if(typeUser == "Personal"){
                    boolean priv = privacyToggle;
                    Personal.createUserPersonal(priv);
                }
                //this will add userName to the list of user file
                /**
                try{
                    BufferedWriter listOfUsers = new BufferedWriter(
                            new FileWriter("C:\\Users\\legas\\Desktop\\apriljavafilefolder\\projectInfo.txt"));
                    listOfUsers.write(User.listOfUserNames.get(0));
                }catch(Exception ex){
                    System.out.println("ex");
                }
                 */
            }
        };

        int yPlacementForButton = 0; //520 for student,310 for teacher, business and personal
        createNewUserButton = new JButton("Create Account");
        createNewUserButton.setBounds(10,yPlacementForButton,80,25);
        //add to panel depending on what is open
        //create ActionListener
        createNewUserButton.addActionListener(createUserListener);




        //global back button to first page

        ActionListener backAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frameForgotPassword.setVisible(false);
                frameNewUser.setVisible(false);
            }
        };



        globalBackButton = new JButton("Back");
        globalBackButton.setBounds(10,0,65,25);
        globalBackButton.addActionListener(backAction);
        newUserPanel.add(globalBackButton);

        /** re add into each action listener
        newUserPanel.add(globalBackButton);
        forgotPasswordPanel.add(globalBackButton);
        **/

        /**
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("User file written");
        pr.flush();
        */

        //creates a new file for each user created
        /**
        try{
            String generatedFileNameForIndividualUsers;
            generatedFileNameForIndividualUsers = String.valueOf(User.userInfo[0]);
            BufferedWriter bw = new BufferedWriter(
                   new FileWriter("C:\\Users\\legas\\Desktop\\apriljavafilefolder"+generatedFileNameForIndividualUsers+".txt"));
            //start writing info



        }catch(Exception ex){
            return;
        }*/

        frameNewUser.setVisible(true);
        frame.setVisible(true);
    }
}