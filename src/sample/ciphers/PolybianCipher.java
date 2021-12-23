package sample.ciphers;

public class PolybianCipher implements Cipher {

//    private final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Override
    public String encrypt(String text, String key) throws PolybiusException {
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
    public String decrypt(String text, String key) {
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


//        StringBuilder table_str = new StringBuilder();
//        table_str.append(key);
//        for (Character letter : alphabyte){
//            if(!key.contains(String.valueOf(letter))){
//                table_str.append(letter);
//            }
//        }
//        char [][] mass = new char[5][5];
//        int counter = 0;
//        for (int i = 0; i < mass.length; i++) {
//            for (int j = 0; j < mass[i].length; j++) {
//                mass[i][j] = table_str.toString().toCharArray()[counter];
//                counter++;
//            }
//        }
//        return mass;
    }

