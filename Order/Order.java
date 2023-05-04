package Order;

import Payment.ShoppingCart;

import java.util.Date;

public class Order {
    private int id;
    private Date creationDate;
    private int userID;
    private float total;
    private static int IDGenerator;

    Order(ShoppingCart shoppingCart) {
        
    }
}
