package Payment;

import Product.Item;

import java.util.Map;

public class ShoppingCart {
    private int cartID;
    private Map<Item, Integer> cartItems;

    public void checkout() {
        new Payment();
    }

    public void addItem(Item cartitem, int quantity) {
        cartItems.
    }


}
/*ShoppingCart

-cartID: int
-cartItems: Map<Item, Integer>
+ checkout() : Order

+addItem(item: CartItem, quantity: int) void

+removeItem(item: CartItem) void

+updateQuantity(item: CartItem, quantity: int) void

+getItems() Map<CartItem, Integer>

+clearCart() void

*/
