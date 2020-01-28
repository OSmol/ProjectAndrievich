package library.security;

public interface PasswordEncryptor {
    String encrypt(String password);
    String decrypt (String password);
}
