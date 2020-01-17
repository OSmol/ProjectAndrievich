package library.service.util;

import java.util.Base64;

public class PasswordUtils {
    public static void verifyUserPassword(String inPassword, String encryptedPassword) {
        Base64.Encoder encoder = Base64.getEncoder();
        if (encryptedPassword.equals(encoder.encodeToString(inPassword.getBytes()))) {
            System.out.println("b");
        } else {
            System.out.println("a");
        }
    }
}
