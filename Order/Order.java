package Order;

import Payment.Payment;
import Payment.ShoppingCart;

import java.util.Date;

public class Order {
    private int id;
    private Date creationDate;
    private double total;
    private static int IDGenerator;

    public Order() {
    }

    public Order(ShoppingCart shoppingCart, Payment payment) {
        id = ++IDGenerator;
        creationDate = payment.getPaymentDate();
        total = payment.getAmount();
    }

    public int getOrderID() {
        return id;
    }

    public double orderTotal() {
        return total;
    }

    public void print() {
        System.out.println("Order ID: " + id + " Date: " + creationDate + " Total = " + total + " $");
    }

    /*public static void main(String[] args) {
        Item item = new Item(1, "Milk", "Cow Milk", 1.05, FullStock, "Lamar", new Category(12, "Beverages"));
        ShoppingCart sc = new ShoppingCart();
        sc.addItem(item, 2);
        Payment payment = new Payment(0, 0, "randomString", 2 * 1.05, CASH_ON_DELIVERY, PaymentStatus.PENDING, sc);
        Order demoOrder = new Order(sc, payment);
        demoOrder.print();
    }*/
}
