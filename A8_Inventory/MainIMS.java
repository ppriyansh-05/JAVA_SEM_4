import java.util.*;

// Product Interface
interface Product {
    void displayDetails();
}

// Legacy Class
class LegacyItem {
    private int itemId;
    private String description;

    // Parameterized Constructor
    public LegacyItem(int itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    // Existing method
    public void print() {
        System.out.println("Legacy Item -> ID: " + itemId + ", Description: " + description);
    }
}

// Adapter Class
class ProductAdapter implements Product {
    private LegacyItem legacyItem;

    public ProductAdapter(LegacyItem legacyItem) {
        this.legacyItem = legacyItem;
    }

    @Override
    public void displayDetails() {
        legacyItem.print(); // Adapting old method
    }
}

// New Product Class
class NewProduct implements Product {
    private String name;

    public NewProduct(String name) {
        this.name = name;
    }

    @Override
    public void displayDetails() {
        System.out.println("New Product -> Name: " + name);
    }
}

// Custom Iterator
class ProductIterator implements Iterator<Product> {
    private List<Product> products;
    private int index = 0;

    public ProductIterator(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return index < products.size();
    }

    @Override
    public Product next() {
        return products.get(index++);
    }
}

// Singleton Inventory Manager
class InventoryManager {
    private static InventoryManager instance;
    private List<Product> productList;

    // Private constructor
    private InventoryManager() {
        productList = new ArrayList<>();
    }

    // Singleton instance getter
    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    // Add product
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Return iterator
    public Iterator<Product> returnInventory() {
        return new ProductIterator(productList);
    }
}

// Main Class
public class MainIMS {
    public static void main(String[] args) {

        // Get Singleton Instance
        InventoryManager manager = InventoryManager.getInstance();

        // Add New Products
        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Smartphone"));

        // Add Legacy Products using Adapter
        LegacyItem item1 = new LegacyItem(101, "Old Keyboard");
        LegacyItem item2 = new LegacyItem(102, "Old Mouse");

        manager.addProduct(new ProductAdapter(item1));
        manager.addProduct(new ProductAdapter(item2));

        // Iterate using Iterator
        Iterator<Product> iterator = manager.returnInventory();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            product.displayDetails();
        }
    }
}