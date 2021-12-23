package sample.ciphers;

public class PolybiusException extends Exception {
    public PolybiusException() {
        super("Длина ключа должна быть равна размерности Квадрата Полибия, то бишь 25!");
    }
}
