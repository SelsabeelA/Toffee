package payment;

import catalog.CatalogManager;
import catalog.Category;
import catalog.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    static int random = 0;
    static int cartID = 0;
    private Map<Item, Integer> cartItems;
    private double priceTotal;
    private CatalogManager catalogManager;
    String contents = "";


    public ShoppingCart(CatalogManager myCatalogManager) {
        cartItems = new HashMap<>();
        this.catalogManager = myCatalogManager;
        //catalogManager.printAllCatalog();
        System.out.println("------------------------");
        // Get the items of the "chocolate" category
        Category chocolateCategory = catalogManager.getCategoryMap().get(1);
        catalogManager.printCategoryItems(chocolateCategory); //prints chocolate items
        //List<Item> chocolateItems = catalogManager.getCategoryItems(chocolateCategory);
        List<Item> chocolateItems = chocolateCategory.getCategoryItems();
        // Add the items to the shopping cart
        int randomquantity = 2;
        for (Item item : chocolateItems) {
            addItem(item, randomquantity++); // Adding a quantity for each chocolate item
        }
        checkout();
        System.out.println("Checkout completed!");
        System.out.println("You have finished adding to the cart and you will be paying " + priceTotal + " LE");
    }

    public void checkout() {
        random++;
        String randomString = "" + random;
        new Payment(random, random, randomString, priceTotal, PaymentMethod.CASH_ON_DELIVERY, PaymentStatus.PENDING, this);
    }


    public void addItem(Item cartItem, int quantity) {
        if (cartItems == null) {
            cartItems.put(cartItem, quantity);
        } else if (cartItems.containsKey(cartItem)) {
            int oldQuantity = cartItems.get(cartItem);
            cartItems.put(cartItem, oldQuantity + quantity);
        }
        priceTotal += cartItem.getPrice() * quantity;
        System.out.println(quantity + " of " + cartItem.getName() + " have been added to the cart, increasing total by "
                + cartItem.getPrice() * quantity);

        contents += quantity + "x " + cartItem.getName() + "\t\t Price: " + cartItem.getPrice() * quantity + "\n";
    }

    public void removeItem(Item cartItem, int quantity) {
        if (cartItems.containsKey(cartItem)) {
            int oldQuantity = cartItems.get(cartItem);
            if ((oldQuantity - quantity) > 0) {
                cartItems.put(cartItem, oldQuantity - quantity);
            } else {
                cartItems.remove(cartItem);
            }
        }
        priceTotal -= cartItem.getPrice() * quantity;

    }

    public Map<Item, Integer> getItems() {
        return cartItems;
    }

    public int getTotalQuantity() {
        int count = 0;
        for (int quantity : cartItems.values()) {
            count += quantity;
        }
        return count;
    }

    public void clearCart() {
        cartItems.clear();
    }

    @Override
    public String toString() {

        contents += "\nTotal Price: " + priceTotal + "\n";
        return contents;
    }
}
