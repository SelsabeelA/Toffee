package payment;

import java.util.Date;

enum PaymentMethod {
    E_WALLET,
    CASH_ON_DELIVERY,
    VOUCHER
}

enum PaymentStatus {
    PENDING,
    COMPLETED,
    CANCELLED
}

public class Payment {
    public static final int PAYMENT_LIMIT = 2000;
    private int paymentID;
    private int ewalletNumber;
    private String paymentCode;
    private double amount;
    private Date paymentDate;
    private PaymentMethod method;
    private PaymentStatus status;
    private payment.ShoppingCart shoppingCart;


    public Payment(int myPaymentID, int myEwalletNumber, String myPaymentCode, double myAmount, PaymentMethod myMethod, PaymentStatus myStatus, payment.ShoppingCart myShoppingCart) {
        this.paymentID = myPaymentID;
        this.ewalletNumber = myEwalletNumber;
        this.paymentCode = myPaymentCode;
        this.amount = myAmount;
        this.paymentDate = new Date(); // this line of code inputs the current date & time
        this.method = myMethod;
        this.status = PaymentStatus.PENDING;
        this.shoppingCart = myShoppingCart;
        processPayment();
    }


    public void processPayment() {
        if (method == PaymentMethod.CASH_ON_DELIVERY) {
            if (status == PaymentStatus.PENDING) {
                status = PaymentStatus.COMPLETED;
                verifyPayment();
                System.out.println("--------------------------");
                System.out.println("Payment confirmed on " + paymentDate);
                System.out.println("Dear user, you have chosen to pay cash on delivery.");
                System.out.println("Please make sure to have " + amount + "LE ready upon delivery.");
            } else {
                System.out.println("Dear user, you cannot pay above the payment limit of " + PAYMENT_LIMIT);
                status = PaymentStatus.CANCELLED;
                System.out.println("Your order has been cancelled.");
            }
        } else if (method != PaymentMethod.CASH_ON_DELIVERY) {
            System.out.println("The other payment methods have not yet been made available.");
        }
    }

    public void cancelPayment(payment.ShoppingCart myShoppingCart) {
        status = PaymentStatus.CANCELLED;
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

    private boolean reachedPaymentLimit(double amount) {
        if (amount > PAYMENT_LIMIT) {
            return false;
        } else {
            return true;
        }
    }

    private boolean verifyPayment() {
        if (status == PaymentStatus.COMPLETED) {
            return true;
        }
        return false;
    }

    private void setPaymentMethod(PaymentMethod method1) {
        method = method1;
    }

}


