import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

    public static void main(String[] args) {
        int length = 12; 
        boolean useUpper = true;
        boolean useLower = true;
        boolean useDigits = true;
        boolean useSpecial = true;

        String password = generatePassword(length, useUpper, useLower, useDigits, useSpecial);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSpecial) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        String charSet = "";
        if (useUpper) {
            charSet += UPPER;
        }
        if (useLower) {
            charSet += LOWER;
        }
        if (useDigits) {
            charSet += DIGITS;
        }
        if (useSpecial) {
            charSet += SPECIAL;
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charSet.length());
            password.append(charSet.charAt(randomIndex));
        }

        return password.toString();
    }
}
