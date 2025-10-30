import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Comparator;

class Product {
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + category + " | " + price;
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product(1, "Laptop", "Electronics", 75000),
            new Product(2, "Phone", "Electronics", 55000),
            new Product(3, "Shoes", "Fashion", 3000),
            new Product(4, "Jacket", "Fashion", 4500),
            new Product(5, "Mixer", "Home", 3500),
            new Product(6, "TV", "Electronics", 60000)
        );

        // 1️⃣ Group products by category
        System.out.println("=== Grouping Products by Category ===");
        Map<String, List<Product>> groupByCategory =
                products.stream().collect(Collectors.groupingBy(Product::getCategory));

        groupByCategory.forEach((category, prodList) -> {
            System.out.println(category + " -> " + prodList);
        });

        // 2️⃣ Find highest-priced product per category
        System.out.println("\n=== Highest-Priced Product per Category ===");
        Map<String, Optional<Product>> maxByCategory =
                products.stream().collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));

        maxByCategory.forEach((category, prod) ->
                System.out.println(category + " -> " + prod.get().getName() + " (" + prod.get().getPrice() + ")"));

        // 3️⃣ Calculate average price overall
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("\nAverage Product Price: " + avgPrice);
    }
}
