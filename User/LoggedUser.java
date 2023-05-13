package User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Revre
 */
public class LoggedUser {
    protected String name;
    protected String email;
    protected String password;
    protected String address;
    protected String userState;
    protected String otherDetails;
    protected List<String> detailsList = new ArrayList<>();

    public LoggedUser(String email, String password) {
        String usersDatabase = "users.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(usersDatabase))) {
            String line;
            while ((line = reader.readLine()) != null) {
                detailsList.add(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        for (int i = 0; i < detailsList.size(); i++) {
            if (detailsList.get(i).equals(email)) {
                if (detailsList.get(i + 1).equals(password)) {
                    System.out.println("password is correct!");
                    break;
                } else if (!detailsList.get(i + 1).equals(password)) {
                    System.out.println("Email/Password is incorrect!");
                    break;
                }
            }
        }
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("UserDetailsList.txt"))) {
            for (String info : detailsList) {
                writer.println(info);
            }
        } catch (FileNotFoundException e) {
        }
    }

    public void logout() {
    }

    public void viewMydetails() {
        System.out.println("name: " + name);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        System.out.println("address: " + address);
        System.out.println("other details: " + otherDetails);
    }
}
