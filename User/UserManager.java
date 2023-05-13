package user;

    import java.io.BufferedReader;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.FileReader;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    import java.util.Properties;
    import javax.mail.Message;
    import javax.mail.MessagingException;
    import javax.mail.Session;
    import javax.mail.Transport;
    import javax.mail.internet.InternetAddress;
    import javax.mail.internet.MimeMessage;

    /**
     *
     * @author Revre
     */
    public class UserManager {
         protected List <String> detailsList = new ArrayList<>();
         public UserManager () throws IOException {
               int userChoose = 0;
               System.out.println("Welcome to User Manager: ");
               System.out.println("Choose: \n"+ "1- Register \n"+ "2- Login \n"+ "3- Set Name \n"+ "4- Set Email \n"+ "5- Set Password\n"+ "6- Set Address\n"+ "7- Set Other Details\n");
               Scanner in = new Scanner(System.in);
               userChoose = in.nextInt();
               switch (userChoose) {
                   case 1:
                       register();
                       break;
                   case 2:
                       login();
                       break;
                   case 3:
                       setName();
                       break;
                   case 4:
                       setEmail();
                       break;
                   case 5:
                       setPassword();
                       break;
                   case 6:
                       setAddress();
                       break;
                   case 7:
                       setOtherDetails();
                       break;
                   default:
                       System.out.println("Invalid choice!");
                       break;
               }
           }
           public void register() throws FileNotFoundException, IOException {
                   String usersDatabase = "users.txt";
                   try (BufferedReader reader = new BufferedReader(new FileReader(usersDatabase))) {
                   String line;
                   while ((line = reader.readLine()) != null) {
                        detailsList.add(line);
                   }
                   } catch (IOException e) {
                        System.err.format("IOException: %s%n", e);
                   }
               System.out.println("Please enter name: ");
               Scanner in = new Scanner(System.in);
               String name = in.nextLine();
               System.out.println("Please enter email: ");
               String email = in.nextLine();
               email = email.toLowerCase();
               for (int i = 0; i < detailsList.size(); i++){
                   if (detailsList.get(i).equals(email)){
                       System.out.println("This Email is already used!");
                       email = in.nextLine();
                   }
               }
               System.out.println("OTP code sent to your email for verification purposes.");
               if(sendOTP(email)) {
            	   System.out.println("Please enter password: ");
                   String password = in.nextLine();
                   System.out.println("Please enter address: ");
                   String address = in.nextLine();
                   LoggedUser newUser = new LoggedUser(email, password);
                   System.out.println("Do you want to add other details? 1- Yes. 2- No.");
                   int choose = in.nextInt();
                   if (choose == 1) {
                       newUser.otherDetails = in.nextLine();
                       detailsList.add(newUser.otherDetails);
                   }
                   else if (choose == 2) {
                       System.out.println("Ok. No other Details.");
                   }
                   detailsList.add(name);
                   detailsList.add(email);
                   detailsList.add(password);
                   detailsList.add(address);
                   try (PrintWriter writer = new PrintWriter(new FileOutputStream("UserDetailsList.txt"))) {
                       for (String info : detailsList) {
                           writer.println(info);
                       }
                   } catch (FileNotFoundException e) {}
               }
               else {
            	   System.out.println("Registration unsuccessful. OTP code wrong.");
               }
           }
           public void login() {
                   String usersDatabase = "users.txt";
                   try (BufferedReader reader = new BufferedReader(new FileReader(usersDatabase))) {
                   String line;
                   while ((line = reader.readLine()) != null) {
                        detailsList.add(line);
                   }
                   } catch (IOException e) {
                        System.err.format("IOException: %s%n", e);
                   }
               Scanner in = new Scanner(System.in);
               System.out.println("Please enter email: ");
               String email = in.nextLine();
               email = email.toLowerCase();
               System.out.println("Please enter password: ");
               String password = in.nextLine();
               for (int i = 0; i < detailsList.size(); i++){
                   if (detailsList.get(i).equals(email)){
                       if (detailsList.get(i+1).equals(password)){
                           System.out.println("password is correct!");
                           break;
                       }
                       else if (!detailsList.get(i+1).equals(password)) {
                           System.out.println("Email/Password is incorrect!");
                           break;
                       }
                   }             
               }
           }
           public void setName() {
               Scanner in = new Scanner(System.in);
               System.out.println("Please enter email: ");
               String email = in.nextLine();
               System.out.println("Please enter password: ");
               String password = in.nextLine();
               LoggedUser user = new LoggedUser(email, password);
               System.out.println("Enter name: ");
               String name = in.nextLine();
               user.name = name;
           }
           public void setEmail() {
               Scanner in = new Scanner(System.in);
               System.out.println("Please enter email: ");
               String email = in.nextLine();
               System.out.println("Please enter password: ");
               String password = in.nextLine();
               LoggedUser user = new LoggedUser(email, password);
               System.out.println("Enter email: ");
               email = in.nextLine();
               user.email = email.toLowerCase();        
           }
           public void setPassword() {
               Scanner in = new Scanner(System.in);
               System.out.println("Please enter email: ");
               String email = in.nextLine();
               System.out.println("Please enter password: ");
               String password = in.nextLine();
               LoggedUser user = new LoggedUser(email, password);
               System.out.println("Enter password: ");
               password = in.nextLine();
               passwordValidation(password);
               user.password = password;
           }
           public void setAddress() {
               Scanner in = new Scanner(System.in);
               System.out.println("Please enter email: ");
               String email = in.nextLine();
               System.out.println("Please enter password: ");
               String password = in.nextLine();
               LoggedUser user = new LoggedUser(email, password);
               System.out.println("Enter address: ");
               String address = in.nextLine();
               user.address = address;
           }
           public void setOtherDetails() {
               Scanner in = new Scanner(System.in);
               System.out.println("Please enter email: ");
               String email = in.nextLine();
               System.out.println("Please enter password: ");
               String password = in.nextLine();
               LoggedUser user = new LoggedUser(email, password);
               System.out.println("Enter other details: ");
               String details = in.nextLine();
               user.otherDetails = details;
           }

          
           public boolean sendOTP(String email) {
        	    // generate OTP code
        	    int otpCode = (int) (Math.random() * 1000000);

        	    // send email with OTP code
        	    String host = "smtp.gmail.com";
        	    String from = "rev.reformer@gmail.com";
        	    String password = "ungeddeglrtndvrp";
        	    String to = email;
        	    String subject = "OTP Code for Payment";
        	    String body = "Your OTP code for payment is: " + otpCode;

        	    Properties props = System.getProperties();
        	    props.put("mail.smtp.starttls.enable", "true");
        	    props.put("mail.smtp.host", host);
        	    props.put("mail.smtp.user", from);
        	    props.put("mail.smtp.password", password);
        	    props.put("mail.smtp.port", "587");
        	    props.put("mail.smtp.auth", "true");

        	    Session session = Session.getDefaultInstance(props);
        	    MimeMessage message = new MimeMessage(session);

        	    try {
        	        message.setFrom(new InternetAddress(from));
        	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        	        message.setSubject(subject);
        	        message.setText(body);
        	        Transport transport = session.getTransport("smtp");
        	        transport.connect(host, from, password);
        	        transport.sendMessage(message, message.getAllRecipients());
        	        transport.close();
        	    } catch (MessagingException me) {
        	        me.printStackTrace();
        	        return false;
        	    }

        	    // prompt user to enter OTP code
        	    Scanner scanner = new Scanner(System.in);
        	    System.out.println("Please enter the OTP code sent to your email:");
        	    int enteredCode = scanner.nextInt();

        	    // compare entered code with generated code
        	    if (enteredCode == otpCode) {
        	        return true;
        	    } else {
        	        return false;
        	    }
        	}

           
           public void passwordValidation (String password){
                boolean upperCaseCheck = false;
                boolean lowerCaseCheck = false;
                boolean numbersCheck = false;
                if (password.length() < 8){
                    System.out.println("Password's length should be at least 8 characters!");
                }
                for (int i = 0; i < password.length(); i++){
                   if (Character.isUpperCase(password.charAt(i))){
                       upperCaseCheck = true;
                   }
                   else if (Character.isLowerCase(password.charAt(i))){
                       lowerCaseCheck = true;
                   }
                   else if (Character.isDigit(password.charAt(i))){
                       numbersCheck = true;
                   }
                   else if (upperCaseCheck == true && lowerCaseCheck == true && numbersCheck == true){
                       System.out.println("Password is ok!");
                       break;
                   }
               }
                if (upperCaseCheck == false || lowerCaseCheck == false || numbersCheck == false){
                    System.out.println("Password is not safe! please enter a password that contains uppercase characters & lowercase characters & numbers.");
                    Scanner in = new Scanner(System.in);
                    password = in.nextLine();
                    passwordValidation(password);
                }
           }
    }

