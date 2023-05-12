package User;

package com.mycompany.mavenproject3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Revre
 */
public class LoggedUser {
    protected String name;
    protected String email;
    protected String password;
    protected String address;
    protected String userState;
    protected String otherDetails;
    protected List <String> detailsList = new ArrayList<>();
    
    public LoggedUser(String email, String password) {
      //  Scanner in = new Scanner(System.in);
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
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("UserDetailsList.txt"))) {
               for (String info : detailsList) {
                   writer.println(info);
               }
           } catch (FileNotFoundException e) {}
    }
    public void logout(){}
    public void viewMydetails(){
        System.out.println("name: "+name);
        System.out.println("email: "+email);
        System.out.println("password: "+password);
        System.out.println("address: "+address);
        System.out.println("other details: "+otherDetails);
    }
}
