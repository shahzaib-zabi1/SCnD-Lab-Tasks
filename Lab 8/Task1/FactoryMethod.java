interface Product {
    void display();
}

class Electronics implements Product {
    @Override
    public void display() {
        System.out.println("This is an Electronics product.");
    }
}

class Clothing implements Product {
    @Override
    public void display() {
        System.out.println("This is a Clothing product.");
    }
}

class Books implements Product {
    @Override
    public void display() {
        System.out.println("This is a Book product.");
    }
}

class ProductFactory {
    public static Product createProduct(String type) {
        if (type.equalsIgnoreCase("electronics")) {
            return new Electronics();
        } else if (type.equalsIgnoreCase("clothing")) {
            return new Clothing();
        } else if (type.equalsIgnoreCase("books")) {
            return new Books();
        } else {
            throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        Product product1 = ProductFactory.createProduct("electronics");
        product1.display();

        Product product2 = ProductFactory.createProduct("clothing");
        product2.display();

        Product product3 = ProductFactory.createProduct("books");
        product3.display();
    }
}
