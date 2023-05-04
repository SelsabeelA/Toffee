package Product;
import java.util.List;

public class CatalogManager {
	private List<Category> categories;

	public Category getCategoryById(int categoryID) {
		for(Category c : categories) {
			if(c.getId() == categoryID ){
				return c;
			}
		}
		return null;
	}
	public void printCategoryItems(Category category) {
		List<Item> items = category.getCategoryItems();
		System.out.println("Products in category " + category.getCategoryName());
		for(Item i: items) {
			System.out.println(i.getName() + " $" + i.getPrice() + " availability:" + i.getAvailability());
			System.out.println("Item description: " + i.getDescription());
		}
	}
	public void printAllCatalog() {
		for(Category c: categories) {
			printCategoryItems(c);
		}
	}
	
}
