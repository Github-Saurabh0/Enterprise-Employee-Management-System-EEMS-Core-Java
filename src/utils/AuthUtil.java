package utils;

public class AuthUtil {

    public static AuthCredentials createCredentials(String rawPassword) {
        String salt = PasswordUtil.generateSalt();
        String hash = PasswordUtil.hashPassword(rawPassword, salt);

        return new AuthCredentials(salt, hash);
    }

    public static boolean login(String rawPassword, String salt, String hash) {
        return PasswordUtil.verify(rawPassword, salt, hash);
    }

    public record AuthCredentials(String salt, String hash) {}
}
