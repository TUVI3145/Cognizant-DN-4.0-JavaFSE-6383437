import java.util.Arrays;
import java.util.Comparator;
public class ECommerceSearch {
     static class Product {
        int productId;
        String productName;
        String category;
        Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }
        @Override
        public String toString() {
            return "[" + productId + ", " + productName + ", " + category + "]";
        }
    }
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Shoes", "Footwear"),
            new Product(102, "Laptop", "Electronics"),
            new Product(103, "Shirt", "Clothing"),
            new Product(104, "Headphones", "Electronics"),
            new Product(105, "Phone", "Electronics")
        };
        String searchTerm = "Phone";
        Product result1 = linearSearch(products, searchTerm);
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Not Found"));
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        Product result2 = binarySearch(products, searchTerm);
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Not Found"));
    }
}
