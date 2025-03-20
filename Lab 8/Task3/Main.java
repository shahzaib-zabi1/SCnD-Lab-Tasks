import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameSettings settings = GameSettings.getInstance();

        while (true) {
            System.out.println("\n===== 🎮 Game Settings Menu =====");
            System.out.println("1️⃣ View Current Settings");
            System.out.println("2️⃣ Set Volume");
            System.out.println(" Set Screen Resolution");
            System.out.println("4️⃣ Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    settings.displaySettings();
                    break;
                case 2:
                    System.out.print("Enter volume (0-100): ");
                    int volume = scanner.nextInt();
                    settings.setVolume(volume);
                    break;
                case 3:
                    System.out.print("Enter screen resolution (e.g., 1920x1080): ");
                    String resolution = scanner.nextLine();
                    settings.setScreenResolution(resolution);
                    break;
                case 4:
                    System.out.println("👋 Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }
}
