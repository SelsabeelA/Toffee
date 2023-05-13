package User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    protected List<String> detailsList = new ArrayList<>();

    public void register() throws FileNotFoundException, IOException {
        System.out.println("Please enter name: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Please enter email: ");
        String email = in.nextLine();
        email = email.toLowerCase();
        System.out.println("Please enter password: ");
        String password = in.nextLine();
        System.out.println("Please enter address: ");
        String address = in.nextLine();
        LoggedUser newUser = new LoggedUser(name, email, password, address);
        System.out.println("Do you want to add other details? 1- Yes. 2- No.");
        int choose = in.nextInt();
        if (choose == 1) {
            newUser.otherDetails = in.nextLine();
            detailsList.add(newUser.otherDetails);
        } else if (choose == 2) {
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
        } catch (FileNotFoundException e) {
        }
    }

    public void login() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter Your Email: ");
        String email = in.nextLine();
        email = email.toLowerCase();
        System.out.println("Please Enter Your Password: ");
        String password = in.nextLine();
        for (int i = 0; i < detailsList.size(); i++) {
            if (detailsList.get(i).equals(email)) {
                if (detailsList.get(i + 1).equals(password)) {
                    System.out.println("Password is correct!");
                    System.out.println("You've Logged in Successfully!");
                    break;
                } else if (!detailsList.get(i + 1).equals(password)) {
                    System.out.println("Email/Password is incorrect!");
                    break;
                }
            }
        }
    }

    public void setName() {
        LoggedUser user = new LoggedUser();
        System.out.println("Enter name: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        user.name = name;
    }

    public void setEmail() {
        LoggedUser user = new LoggedUser();
        System.out.println("Enter email: ");
        Scanner in = new Scanner(System.in);
        String email = in.nextLine();
        user.email = email.toLowerCase();
    }

    public void setPassword() {
        LoggedUser user = new LoggedUser();
        System.out.println("Enter password: ");
        Scanner in = new Scanner(System.in);
        String password = in.nextLine();
        user.password = password;
    }

    public void setAddress() {
        LoggedUser user = new LoggedUser();
        System.out.println("Enter address: ");
        Scanner in = new Scanner(System.in);
        String address = in.nextLine();
        user.address = address;
    }

    public void setOtherDetails() {
        LoggedUser user = new LoggedUser();
        System.out.println("Enter other details: ");
        Scanner in = new Scanner(System.in);
        String details = in.nextLine();
        user.otherDetails = details;
    }
}
