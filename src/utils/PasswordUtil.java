package utils;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtil {

    // Generate random salt
    public static String generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Hash password with salt
    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            md.update(Base64.getDecoder().decode(salt)); // Add salt
            byte[] hashed = md.digest(password.getBytes());

            return Base64.getEncoder().encodeToString(hashed);

        } catch (Exception e) {
            throw new RuntimeException("Password hashing failed: " + e.getMessage());
        }
    }

    // Verify if provided password matches stored hash
    public static boolean verify(String password, String salt, String storedHash) {
        String hashedPassword = hashPassword(password, salt);
        return hashedPassword.equals(storedHash);
    }
}
