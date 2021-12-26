package sample.ciphers;

public interface Cipher {
    String encrypt() throws PolybiusException;
    String decrypt();
}
