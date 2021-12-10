package sample.ciphers;

public class CipherFactory {
    public Cipher getCipher(String type){
        Cipher toReturn = null;
        switch(type){
            case "Шифр Скитала":
                toReturn = new ScytaleCipher();
                break;
            case "Полибианский квадрат":
                toReturn = new PolybianCipher();
                break;
            case "Шифр Уитстона":
                toReturn = new WuitstonCipher();
                break;
        }
        return toReturn;
    }
}
