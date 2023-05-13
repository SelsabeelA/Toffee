package order;

import payment.ShoppingCart;

import java.util.Date;

public class Order {
    private int id;
    private Date creationDate;
    private double total;
    private static int IDGenerator;
    private String orderContent;

    public Order() {
    }

    public Order(ShoppingCart shoppingCart) {
        id = ++IDGenerator;
        creationDate = new Date();
        total = shoppingCart.getTotalQuantity();
        orderContent = shoppingCart.toString();

        System.out.println();
        System.out.println("Your order is officially confirmed.");
    }

    int getOrderID() {
        return id;
    }

    public void printOrder() {

        System.out.println(orderContent);

    }


}
