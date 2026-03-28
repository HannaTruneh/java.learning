import java.util.ArrayList;
import java.util.List;

abstract class Product {

    String name;
    double weight;

    public Product(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    abstract void productInfo();
}

class Fruit extends Product {

    String color;

    public Fruit(String name, double weight, String color) {
        super(name, weight);
        this.color = color;
    }

    @Override
    void productInfo() {
        System.out.println("Name: " + name);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Color: " + color);
    }
}

class Vegetable extends Product {

    boolean isLeafy;

    public Vegetable(String name, double weight, boolean isLeafy) {
        super(name, weight);
        this.isLeafy = isLeafy;
    }

    @Override
    void productInfo() {
        String leafyInfo = isLeafy ? "Yes" : "No";
        System.out.println("Name: " + name);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Leafy: " + leafyInfo);
    }
}

interface Shopper {
    String getName();

    void addProduct(Product product);
}

class Customer implements Shopper {
    private String name;
    private List<Product> products;

    public Customer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    void printProducts() {
        System.out.println("Products of " + name + ":");
        for (Product product : products) {
            product.productInfo();
            System.out.println("-------------------");
        }
    }
}

public class FruitVegetableDemo {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        Fruit apple = new Fruit("Apple", 0.2, "Red");
        Vegetable lettuce = new Vegetable("Lettuce", 0.5, true);
        Vegetable carrot = new Vegetable("Carrot", 0.3, false);


        customer.addProduct(apple);
        customer.addProduct(lettuce);
        customer2.addProduct(lettuce);
        customer2.addProduct(carrot);

        for (Customer c : List.of(customer, customer2)) {
            System.out.println("Customer: " + c.getName());
            c.printProducts();
        }
    }
}
