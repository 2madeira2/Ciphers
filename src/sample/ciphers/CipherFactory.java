package sample.ciphers;

public class CipherFactory {

    private final String text;
    private final String key;

    public CipherFactory(String text, String key){
        this.text = text;
        this.key = key;
    }


    public Cipher getCipher(String type){
        Cipher toReturn = null;
        switch(type){
            case "Шифр Скитала":
                toReturn = new ScytaleCipher(text, key);
                break;
            case "Полибианский квадрат":
                toReturn = new PolybiusCipher(text, key);
                break;
            case "Шифр Уитстона":
                toReturn = new WheatStoneCipher(text, key);
                break;
        }
        return toReturn;
    }
}
