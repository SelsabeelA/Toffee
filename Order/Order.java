package Order;

import Payment.Payment;
import Payment.ShoppingCart;

import java.util.Date;

public class Order {
    private int id;
    private Date creationDate;
    private double total;
    private static int IDGenerator;

    Order(ShoppingCart shoppingCart, Payment payment) {
        id = ++IDGenerator;
        creationDate = payment.getPaymentDate();
        total = payment.getAmount();
    }


}
