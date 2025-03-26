import java.util.Scanner;

class ProductCatalog {
    public void checkProductAvailability(String product) {
        System.out.println("Checking availability of: " + product);
    }
}

class PaymentProcessor {
    public void processPayment(String paymentType) {
        System.out.println("Processing payment using: " + paymentType);
    }
}

class OrderManager {
    public void createOrder(String product) {
        System.out.println("Order placed for: " + product);
    }
}

class ShopFacade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private OrderManager orderManager;

    public ShopFacade() {
        this.productCatalog = new ProductCatalog();
        this.paymentProcessor = new PaymentProcessor();
        this.orderManager = new OrderManager();
    }

    public void placeOrder(String product, String paymentType) {
        System.out.println("\nPlacing order for: " + product);
        productCatalog.checkProductAvailability(product);
        paymentProcessor.processPayment(paymentType);
        orderManager.createOrder(product);
        System.out.println("Order placed successfully!\n");
    }
}

public class task1facade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShopFacade shop = new ShopFacade();

        System.out.println("Welcome to the Shopping System!");

        while (true) {
            System.out.print("\nEnter Product Name (or type 'exit' to quit): ");
            String product = scanner.nextLine();
            if (product.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the shopping system. Thank you!");
                break;
            }

            System.out.print("Enter Payment Method (Credit Card / PayPal / Cash): ");
            String paymentType = scanner.nextLine();
            shop.placeOrder(product, paymentType);
        }

        scanner.close();
    }
}
