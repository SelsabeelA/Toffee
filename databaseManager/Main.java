package databaseManager;

import User.UserManager;
import catalog.CatalogManager;
import order.Order;
import payment.ShoppingCart;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public void Menu() {
        System.out.println("\t\t --------------");
        System.out.println("\t\t| TOFFEE STORE |");
        System.out.println("\t\t --------------");
        System.out.println();

        System.out.println("Type 1 to See The Catalog");
        System.out.println("Type 2 to Login");
        System.out.println("Type 3 to Create a New Account");
        System.out.println("Type 4 to Exit");
        System.out.println("Type any other thing to go back to the Main Menu");
        System.out.println();

        System.out.print("Enter Your Choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println();
        System.out.println("-----------------------------------");

        if (choice == 1) {
            CatalogManager c1 = new CatalogManager();
            c1.printAllCatalog();
            Menu();
        } else if (choice == 2) {
            UserManager userManage = new UserManager();
            System.out.println("\t\t --------");
            System.out.println("\t\t| Log In |");
            System.out.println("\t\t --------");
            System.out.println();
            userManage.login();
            CatalogManager c1 = new CatalogManager();
            System.out.println("You Wanna Add Some Items to Your Cart?");
            System.out.println("Type Y for Yes, and N for No: ");
            char cartChoice = sc.next().charAt(0);
            if (cartChoice == 'y' || cartChoice == 'Y') {
                ShoppingCart s1 = new ShoppingCart(c1);
                Order o1 = new Order(s1);
                o1.printOrder();
            }
            System.out.println();
            System.out.println();
            Menu();
        } else if (choice == 3) {
            UserManager userManage = new UserManager();
            System.out.println();
            System.out.println("\t\t -----------");
            System.out.println("\t\t| Register |");
            System.out.println("\t\t -----------");
            System.out.println();
            try {
                userManage.register();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            CatalogManager c1 = new CatalogManager();
            System.out.println("You Wanna Add Some Items to Your Cart?");
            System.out.println("Type Y for Yes, and N for No: ");
            char cartChoice = sc.next().charAt(0);
            if (cartChoice == 'y' || cartChoice == 'Y') {
                ShoppingCart s1 = new ShoppingCart(c1);
                Order o1 = new Order(s1);
                o1.printOrder();
            }
            System.out.println();
            System.out.println();
            Menu();
        } else if (choice == 4) {
            exit(1);
        } else {
            Menu();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main main = new Main();
        main.Menu();
    }

}
