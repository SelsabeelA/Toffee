package User;

public class LoggedUser extends GeneralUser {
    protected String name;
    protected String email;
    protected String password;
    protected String address;
    protected String userState;
    protected String otherDetails;

    public LoggedUser() {
    }

    public LoggedUser(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public void logout() {
    }

    public void viewMydetails() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Address: " + address);
        System.out.println("Other Details: " + otherDetails);
    }
}
