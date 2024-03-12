package GoRest.utils;

import java.util.Random;

public class RandomGen {
    public static String generateRandomName() {
        return "maira" + new Random().nextInt(1000);
    }

    public static String generateDynamicEmail() {
        return "maira" + new Random().nextInt(1000) + "@gmail.com";
    }
}
