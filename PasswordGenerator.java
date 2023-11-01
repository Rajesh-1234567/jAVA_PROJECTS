// PASSWORD GEnERATOR
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        int length = 10;
        System.out.println("Generating password using random");
        String password = generatePassword(length);
        System.out.println("Your new password is: " + password);
    }

    static String generatePassword(int len) {
        
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&()_+=/.?<>";
        String values = capitalChars + smallChars + numbers + symbols;
        
        Random rndmMethod = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < len; i++) {
            password.append(values.charAt(rndmMethod.nextInt(values.length())));
        }

        return password.toString();
    }
}
