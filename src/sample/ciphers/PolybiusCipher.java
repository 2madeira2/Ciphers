package sample.ciphers;

public class PolybiusCipher implements Cipher {

    private final String text;
    private final String key;

    public PolybiusCipher(String text, String key){
        this.text = text;
        this.key = key;
    }

    @Override
    public String encrypt() throws PolybiusException {
        if(key.length()!=25){
            throw new PolybiusException();
        }
        char [][] mass = getAlphabetUsingKey(key);
        StringBuilder result_str = new StringBuilder();
        for(char letter : text.toCharArray()){
            for(int i = 0; i < mass.length; i++){
                for(int j = 0; j < mass[i].length; j++){
                    if (mass[i][j] == letter){
                        if(i!=mass.length-1)
                            result_str.append(mass[i + 1][j]);
                        else
                            result_str.append(mass[0][j]);
                    }
                }
            }
        }
        return result_str.toString();
    }

    @Override
    public String decrypt() {
        char [][] mass = getAlphabetUsingKey(key);
        StringBuilder result_str = new StringBuilder();
        for(char letter : text.toCharArray()){
            for(int i = 0; i < mass.length; i++){
                for(int j = 0; j < mass[i].length; j++){
                    if (mass[i][j] == letter){
                        if (i == 0)
                            result_str.append(mass[mass.length - 1][j]);
                        else
                            result_str.append(mass[i - 1][j]);
                    }
                }
            }
        }
        return result_str.toString();
    }


    private char[][] getAlphabetUsingKey(String key) {
        char[][] mass = new char[5][5];
        int counter = 0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                mass[i][j] = key.toCharArray()[counter];
                counter++;
            }
        }
        return mass;
    }
}
