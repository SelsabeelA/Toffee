package Payment;

import Order.Order;

import java.util.Date;

enum PaymentMethod {
    EWallet,
    OnDelivery,
    Voucher
}

enum PaymentStatus {
    Pending,
    Completed,
    Cancelled
}

public class Payment {
    private int paymentID;
    private int ewalletNumber;
    private String paymentCode;
    private double amount;
    private Date paymentDate;
    private PaymentMethod method;
    private PaymentStatus status;
    private ShoppingCart shoppingCart;

    public Payment(ShoppingCart shoppingCart1) {
        this.shoppingCart = shoppingCart1;
    }

    public Payment(int myPaymentID, int myEwalletNumber, String myPaymentCode, double myAmount, Date myPaymentDate, PaymentMethod myMethod, PaymentStatus myStatus) {
        this.paymentID = myPaymentID;
        this.ewalletNumber = myEwalletNumber;
        this.paymentCode = myPaymentCode;
        this.amount = myAmount;
        this.paymentDate = myPaymentDate;
        this.method = myMethod;
        this.status = myStatus;
    }

    public Order processPayment(ShoppingCart s) {

    }

    public void cancelPayment(ShoppingCart s) {
        //code
    }

    public void generatePaymentCode() {
        //code
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void sendOTP(int phonenum) {
        //code to send OTP
    }

    private boolean verifyOTP(int otpcode) {
        // code to verify OTP
        return true;
    }

    private boolean checkPaymentLimit(double amount) {
        // code to check payment limit
        return true;
    }

    private boolean verifyPayment() {
        if (this.status.equals("Completed")) {
            System.out.println("Payment verified!");
            new Order(payment);
            return true;
        } else {
            return false;
        }
    }

}


