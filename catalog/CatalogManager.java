package catalog;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CatalogManager {
	private List<Category> categories;
    private Map<Integer, Category> categoryMap;

    
	public CatalogManager() {
        categoryMap = new HashMap<>();
		//tester, just put in random items loaded from file
		try (BufferedReader br = new BufferedReader(new FileReader("categories.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int categoryId = Integer.parseInt(values[0]);
                String categoryName = values[1];
                Category category = new Category(categoryId, categoryName);
                getCategoryMap().put(categoryId, category);
                }
            categories = new ArrayList<>(categoryMap.values());
        } catch (Exception e) {
            System.out.println("Error reading categories file: " + e.getMessage());
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int itemId = Integer.parseInt(values[0]);
                String itemName = values[1];
                String itemDescription = values[2];
                float itemPrice = Float.parseFloat(values[3]);
                AvailabilityStatus itemAvailability = AvailabilityStatus.valueOf(values[4]);
                String itemBrand = values[5];
                int itemCategoryId = Integer.parseInt(values[6]);
                Category itemCategory = getCategoryMap().get(itemCategoryId);
                Item item = new Item(itemId, itemName, itemDescription, itemPrice, itemAvailability, itemBrand, itemCategory);
                itemCategory.addItem(item);
            }
            
        } catch (Exception e) {
            System.out.println("Error reading items file: " + e.getMessage());
            return;
        }
		//printCategoryItems(categoryMap.get(1)); // prints chocolate items
	}
	public Category getCategoryById(int categoryID) {
		for(Category c : categories) {
			if(c.getId() == categoryID ){
				return c;
			}
		}
		return null;
	}
	
	public List<Item> getCategoryItems(Category category) {
	    if (category == null) {
	        return null;
	    }
	    return category.getCategoryItems();
	}

	public void printCategoryItems(Category category) {
	    if (category == null) {
	        System.out.println("Category is null");
	        return;
	    }
		List<Item> items = category.getCategoryItems();
		System.out.println("Products in category " + category.getCategoryName());
		for(Item i: items) {
			System.out.println(i.getName() + " $" + i.getPrice() + " availability: " + i.getAvailability());
			System.out.println("Item description: " + i.getDescription());
		}
		System.out.println("-----------------------");
	}
	public void printAllCatalog() {
	    if (categories == null) {
	        System.out.println("No categories here.");
	        return;
	    }
		for(Category c: categories) {
			printCategoryItems(c);
		}
	}
	
	public List<Category> getCategories(){
		return categories;
	}
	public Map<Integer, Category> getCategoryMap() {
		return categoryMap;
	}
	
	
}
