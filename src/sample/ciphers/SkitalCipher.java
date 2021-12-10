package sample.ciphers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SkitalCipher implements Cipher {
    @Override
    public String encrypt(String text, String key) {
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
        return Arrays.deepToString(mass);
    }

    @Override
    public String decrypt(String text, String key) {
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
        map.put("rows", Integer.toString(rows));
        map.put("col", Integer.toString(col));
        map.put("text", text);
        return map;
    }
}
