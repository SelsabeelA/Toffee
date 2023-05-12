package User;
public class LoggedUser extends GeneralUser {
    protected String name;
    protected String email;
    protected String password;
    protected String address;
    protected String userState;
    protected String otherDetails;
    public LoggedUser(){}
    public LoggedUser(String email, String password) {
        this.email = email;
        this.password = password;
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
