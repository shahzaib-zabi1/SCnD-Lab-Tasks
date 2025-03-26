import java.util.Scanner;

interface NewPaymentGateway {
    void processPayment(String accountNumber, double amount);
}

class OldPaymentGateway {
    public void payWithCard(String cardNumber, double amount) {
        System.out.println("\n Payment Successful!");
        System.out.println("Card Number: " + maskCardNumber(cardNumber));
        System.out.println(" Amount Paid: $" + amount);
        System.out.println("Processed via Old Payment Gateway");
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() < 4)
            return "****";
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }
}

class PaymentAdapter implements NewPaymentGateway {
    private OldPaymentGateway oldPaymentGateway;

    public PaymentAdapter(OldPaymentGateway oldPaymentGateway) {
        this.oldPaymentGateway = oldPaymentGateway;
    }

    @Override
    public void processPayment(String accountNumber, double amount) {
        System.out.println("\nUsing Adapter: Converting 'processPayment()' to 'payWithCard()'");
        oldPaymentGateway.payWithCard(accountNumber, amount);
    }
}

public class task3adapter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Card Number: ");
        String cardNumber = scanner.nextLine();

        System.out.print("Enter Payment Amount: $");
        double amount = scanner.nextDouble();

        OldPaymentGateway oldSystem = new OldPaymentGateway();
        NewPaymentGateway paymentGateway = new PaymentAdapter(oldSystem);

        paymentGateway.processPayment(cardNumber, amount);

        scanner.close();
    }
}
