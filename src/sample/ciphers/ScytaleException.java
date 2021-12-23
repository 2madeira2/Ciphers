package sample.ciphers;

public class ScytaleException extends Exception{

    public ScytaleException() {
            super("Длина ключа должна быть равна размерности Квадрата Полибия, то бишь 25!");
        }

}
