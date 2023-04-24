package util;

import javax.crypto.spec.PSource;
import java.util.Random;

public class Utils {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static String generateRandomString(int n) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random random = new Random();
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
    public static String generateRandomNumberAsString() {
        Random random = new Random();
        long randomNumber = (long) (random.nextDouble() * 9_000_000_000L) + 1_000_000_000L;
        return Long.toString(randomNumber);
    }
    public static void printHeaderMenu() {
        System.out.println("            _ _ _ _ _ 0 0 0 _ _ _ _ _              ");
        System.out.println("                      MENU                         ");
    }

    public static void printFooterMenu() {
        System.out.println("                  * * * * * * *                    ");
    }
    public static void printFooterDisplay() {
        System.out.println("----------------------------------------------------");
    }
}