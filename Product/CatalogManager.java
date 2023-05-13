package product;

import java.util.List;

public class CatalogManager {
    private List<Category> categories;

    CatalogManager() {
        printAllCatalog();
        System.out.println("------------------------");
    }

    public Category getCategoryById(int categoryID) {
        for (Category c : categories) {
            if (c.getId() == categoryID) {
                return c;
            }
        }
        return null;
    }

    public void printCategoryItems(Category category) {
        List<Item> items = category.getCategoryItems();
        System.out.println("Products in category " + category.getCategoryName());
        for (Item i : items) {
            System.out.println(i);
        }
    }

    public void printAllCatalog() {
        for (Category c : categories) {
            printCategoryItems(c);
        }
    }

}
