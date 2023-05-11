package product;

enum AvailabilityStatus {
    FullStock,
    OutOfStock,
    LowInStock
}

public class Item {
    private int id;
    private String name;
    private String description;
    private float price;
    private AvailabilityStatus availability;
    private String brand;
    private Category category;

    public Item(int id, String name, String description, float price, AvailabilityStatus availability, String brand, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.availability = availability;
        this.brand = brand;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public AvailabilityStatus getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return name + " $" + price + " availability:" + availability
                + "\nItem description: " + description;
    }
}
