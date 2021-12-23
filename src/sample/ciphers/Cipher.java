package sample.ciphers;

public interface Cipher {
    String encrypt(String text, String key) throws PolybiusException;
    String decrypt(String text, String key);
}
