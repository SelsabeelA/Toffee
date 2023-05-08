package order;

import payment.ShoppingCart;
import product.Item;

import java.util.Date;

public class Order {
    private int id;
    private Date creationDate;
    private double total;
    private static int IDGenerator;
    private List<Item> items;

    public Order() {
    }

    public Order(ShoppingCart shoppingCart) {
        id = ++IDGenerator;
        creationDate = new Date();
        total = shoppingCart.getTotalQuantity();

        for (Item item : shoppingCart.getItems())
            items.add(item);

        System.out.println("Your order is officially confirmed.");
    }

    public void print() {

        System.out.println("OrderID: " + id + " Date:" + creationDate + "Total: " + total);
        for (Item item : items) {
            System.out
        }

    }


}
