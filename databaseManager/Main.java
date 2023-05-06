package databaseManager;
import catalog.CatalogManager;
import order.Order;
import payment.Payment;
import payment.ShoppingCart;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CatalogManager c1 = new CatalogManager();
		
		ShoppingCart s1 = new ShoppingCart(c1);
		Order o1 = new Order(s1);
		}

}
