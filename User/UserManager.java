package User;

package com.mycompany.mavenproject2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    public void register() throws FileNotFoundException, IOException {
        System.out.println("Please enter name: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Please enter email: ");
        String email = in.nextLine();
        System.out.println("Please enter password: ");
        String password = in.nextLine();
        System.out.println("Please enter address: ");
        String address = in.nextLine();
        LoggedUser newUser = new LoggedUser(name, email, password, address);
        System.out.println("Do you want to add other details? 1- Yes. 2- No.");
        int choose = in.nextInt();
        if (choose == 1) {
        Scanner o = new Scanner(System.in);
        newUser.otherDetails = o.nextLine();
        }
        else if (choose == 2) {
            System.out.println("Ok. No other Details.");
        }
        List <String> detailsList = new ArrayList<>();
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
    public void login() {}
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
        user.email = email;        
    }
    public void setPassword() {
        LoggedUser user = new LoggedUser();
        System.out.println("Enter password: ");
        Scanner in = new Scanner(System.in);
        String password = in.nextLine();
        user.password = password;
    }
    public void setOtherDetails() {
        LoggedUser user = new LoggedUser();
        System.out.println("Enter other details: ");
        Scanner in = new Scanner(System.in);
        String details = in.nextLine();
        user.otherDetails = details;
    }
}
