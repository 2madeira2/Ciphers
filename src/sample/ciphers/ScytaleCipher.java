package sample.ciphers;

import java.util.HashMap;
import java.util.Map;

public class ScytaleCipher implements Cipher {

    private String text;
    private final String key;

    public ScytaleCipher(String text, String key){
        this.text = text;
        this.key = key;
    }

    @Override
    public String encrypt() {
        int rows = Integer.parseInt(getParameters(text, key).get("rows"));
        int col = Integer.parseInt(getParameters(text, key).get("col"));
        text = getParameters(text, key).get("text");
        int counter = 0;
        char[][] mass = new char[rows][col];
            for(int i = 0; i < col; i++){
                for(int j = 0; j < rows; j++){
                    mass[j][i] = text.toCharArray()[counter];
                    counter++;
                }
            }
        StringBuilder result = new StringBuilder();
        for (char[] chars : mass) {
            for (char aChar : chars) {
                result.append(aChar);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt() {
        int rows = Integer.parseInt(getParameters(text, key).get("rows"));
        int col = Integer.parseInt(getParameters(text, key).get("col"));
        text = getParameters(text, key).get("text");
        StringBuilder result = new StringBuilder();
        char[][] mass = new char[rows][col];
        int counter = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < col; j++) {
                mass[i][j] = text.toCharArray()[counter];
                counter++;
            }
        }
        for(int i = 0; i < col; i++){
            for(int j = 0; j < rows; j++) {
                result.append(mass[j][i]);
            }
        }
        return result.toString();
    }

    private Map<String, String> getParameters(String text, String key){
        Map<String, String> map = new HashMap();
        int rows = Integer.parseInt(key);
        int col;
        if(text.length() % rows == 0) {
            col = text.length() / rows;
        }
        else {
            col = text.length() / rows + 1;
            int dop = col * rows - text.length();
            StringBuilder dop_str = new StringBuilder();
            for (int i = 0; i < dop; i++)
                dop_str.append(" ");
            text += dop_str;
        }
        map.put("rows", Integer.toString(col));
        map.put("col", Integer.toString(rows));
        map.put("text", text);
        return map;
    }
}
