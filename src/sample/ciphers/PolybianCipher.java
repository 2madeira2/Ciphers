package sample.ciphers;

public class PolybianCipher implements Cipher {

    private final char[] alphabyte = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Override
    public String encrypt(String text, String key) {
        char [][] mass = getAlphabyteUsingKey(key);
        String result_str = "";
        for(char letter : text.toCharArray()){
            for(int i = 0; i < mass.length; i++){
                for(int j = 0; j < mass[i].length; j++){
                    if (mass[i][j] == letter){
                        if(i!=mass.length-1)
                            result_str+=mass[i+1][j];
                        else
                            result_str+=mass[0][j];
                    }
                }
            }
        }
        return result_str;
    }

    @Override
    public String decrypt(String text, String key) {
        char [][] mass = getAlphabyteUsingKey(key);
        String result_str = "";
        for(char letter : text.toCharArray()){
            for(int i = 0; i < mass.length; i++){
                for(int j = 0; j < mass[i].length; j++){
                    if (mass[i][j] == letter){
                        if (i == 0)
                            result_str+=mass[mass.length-1][j];
                        else
                            result_str+=mass[i-1][j];
                    }
                }
            }
        }
        return result_str;
    }


    private char[][] getAlphabyteUsingKey(String key){
        StringBuilder table_str = new StringBuilder();
        table_str.append(key);
        for (Character letter : alphabyte){
            if(!key.contains(String.valueOf(letter))){
                table_str.append(letter);
            }
        }
        char [][] mass = new char[5][5];
        int counter = 0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                mass[i][j] = table_str.toString().toCharArray()[counter];
                counter++;
            }
        }
        return mass;
    }
}
