package Payment;

import Product.Item;

import java.util.Map;

public class ShoppingCart {
	static int random = 0;
    private int cartID;
    private Map<Item, Integer> cartItems;
    private double total;


    public void checkout() {
    	random++;
    	String randomString = "" + random;
        new Payment(random,random, randomString,total, PaymentMethod.CASH_ON_DELIVERY, PaymentStatus.PENDING, this);
    }


    public void addItem(Item cartItem, int quantity) {
        if(cartItems.containsKey(cartItem)) {
        	int oldQuantity = cartItems.get(cartItem);
        	cartItems.put(cartItem, oldQuantity + quantity);
        }
        else {
        	cartItems.put(cartItem, quantity);
        }
        total +=quantity;
    }
    
    public void removeItem(Item cartItem, int quantity) {
        if(cartItems.containsKey(cartItem)) {
        	int oldQuantity = cartItems.get(cartItem);
        	if((oldQuantity - quantity)>0) {
            	cartItems.put(cartItem, oldQuantity - quantity);
        	}
        	else {
        		cartItems.remove(cartItem);
        	}
        }
    }
    
    public void updateQuantity(Item cartItem, int quantity) {
    	cartItems.put(cartitem, quantity);
    }
    
    public Map<Item, Integer> getItems(){
    	return cartItems;
    }
    
    public void clearCart() {
    	cartItems.clear();
    }


}

