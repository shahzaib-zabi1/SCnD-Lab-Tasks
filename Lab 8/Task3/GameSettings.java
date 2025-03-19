public class GameSettings {

    private static GameSettings instance;

    private int volume;
    private String screenResolution;

    private GameSettings() {
        this.volume = 50; // Default volume level
        this.screenResolution = "1920x1080"; // Default resolution
    }

    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }
    public void setVolume(int level) {
        if (level >= 0 && level <= 100) {
            this.volume = level;
        } else {
            System.out.println("❌ Volume must be between 0 and 100!");
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setScreenResolution(String resolution) {
        this.screenResolution = resolution;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void displaySettings() {
        System.out.println("🎮 Game Settings:");
        System.out.println("🔊 Volume: " + volume);
        System.out.println("🖥  Resolution: " + screenResolution);
    }
}
