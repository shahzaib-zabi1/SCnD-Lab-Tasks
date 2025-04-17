import java.util.*;

interface DisplayStrategy {
    void display(float temperature, float humidity);
}
class DigitalDisplayStrategy implements DisplayStrategy {
    public void display(float temperature, float humidity) {
        System.out.println("Digital Display: Temp = " + temperature + "°C, Humidity = " + humidity + "%");
    }
}

class StatisticsBoardStrategy implements DisplayStrategy {
    public void display(float temperature, float humidity) {
        System.out.println("Statistics Board: Temp: " + temperature + "°C, Humidity: " + humidity + "%");
    }
}

class MobileAlertStrategy implements DisplayStrategy {
    public void display(float temperature, float humidity) {
        System.out.println("Mobile Alert: It's currently " + temperature + "°C!");
    }
}

class NewsChannelStrategy implements DisplayStrategy {
    public void display(float temperature, float humidity) {
        System.out.println("News Channel: BREAKING! Weather Update - " + temperature + "°C, " + humidity + "% humidity");
    }
}

class WeatherStation {
    private float temperature;
    private float humidity;
    private List<DisplayStrategy> strategies = new ArrayList<>();

    public WeatherStation() {
        strategies.add(new DigitalDisplayStrategy());
        strategies.add(new StatisticsBoardStrategy());
        strategies.add(new MobileAlertStrategy());
        strategies.add(new NewsChannelStrategy());
    }

    public void setWeatherData(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyAllDisplays();
    }

    private void notifyAllDisplays() {
        for (DisplayStrategy strategy : strategies) {
            strategy.display(temperature, humidity);
        }
        System.out.println("----------------------------------------------------");
    }
}


public class WeatherSystemStrategy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherStation station = new WeatherStation();
        int updateCount = 1;

        System.out.println("Welcome to the Weather Monitoring System!");
        
        String continueInput;
        do {
            System.out.println("\nEnter new weather data for update " + updateCount + ":");

            System.out.print("Enter temperature (°C): ");
            float temp = scanner.nextFloat();

            System.out.print("Enter humidity (%): ");
            float humidity = scanner.nextFloat();

            System.out.println("\nBroadcasting weather update...");
            station.setWeatherData(temp, humidity);

            updateCount++;

            System.out.print("\nDo you want to continue? (yes/no): ");
            scanner.nextLine(); 
            continueInput = scanner.nextLine().trim().toLowerCase();

        } while (continueInput.equals("yes"));

        System.out.println("Exiting... Thank you for using the Weather Monitoring System.");
        scanner.close();
    }
}
