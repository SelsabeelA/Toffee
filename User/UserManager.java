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
       public void login() {
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
   }
