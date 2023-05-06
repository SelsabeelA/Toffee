package order;

import java.util.Date;

import payment.Payment;
import payment.ShoppingCart;

public class Order {
    private int id;
    private Date creationDate;
    private double total;
    private static int IDGenerator;

    public Order(ShoppingCart shoppingCart) {
        id = ++IDGenerator;
        creationDate = new Date();
        total = shoppingCart.getTotalQuantity();
        System.out.println("Your order is officially confirmed.");
        System.out.println("OrderID: " +id+ " date:" + creationDate + total);
        
    }

}
