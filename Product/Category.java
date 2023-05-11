package product;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private List<Item> items;
    private int categoryID;
    private String categoryName;

    public Category(int newCategoryID, String newCategoryName) {
        this.categoryID = newCategoryID;
        this.categoryName = newCategoryName;
        items = new ArrayList<>();
    }

    public int getId() {
        return categoryID;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item searchById(int id) {
        for (Item i : items) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public List<Item> searchByName(String itemName) {
        List<Item> itemsWithThisName = new ArrayList<>();
        for (Item i : items) {
            if (i.getName().equals(itemName)) {
                itemsWithThisName.add(i);
            }
        }
        return itemsWithThisName;
    }

    public List<Item> getCategoryItems() {
        return items;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
