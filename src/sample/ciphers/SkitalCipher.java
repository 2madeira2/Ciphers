package sample.ciphers;

import sample.ciphers.Cipher;

public class SkitalCipher implements Cipher {
    @Override
    public String encrypt(String text, String key) {
        int row = Integer.parseInt(key);
        StringBuilder output = new StringBuilder();

        int col = Math.round((text.length() / row) + 1);
        int diff = row - ((row * col) - text.length());
        int strI = 0;

        char[][] t = new char[row][col];

        System.out.println("info: " + row + "," + col + "," + text.length());

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (j == col - 1 && diff <= 0 || strI >= text.length()) {
                    t[i][j] = '@';
                } else {
                    t[i][j] = text.charAt(strI);
                    strI++;
                }
            }
            diff--;
        }

        for (int i = 0; i < t[0].length; i++) {
            for (char[] chars : t) {
                if (chars[i] != '@') {
                    output.append(chars[i]);
                }
            }
        }

        return output.toString();
    }

    @Override
    public String decrypt(String text, String key) {
        int row = Integer.parseInt(key);
        StringBuilder output = new StringBuilder();

        int col = Math.round((text.length() / row) + 1);
        int diff = row - ((row * col) - text.length());
        int strI = 0;

        StringBuilder ps = new StringBuilder();

        for (int i = 0; i < row * col; i++)
        {
            if (strI >= text.length()) {
                ps.append('@');
            } else {
                ps.append(text.charAt(strI));
                strI++;
            }
        }

        strI = 0;

        char[][] t = new char[row][col];

        for (int i = 0; i < t[0].length; i++)
        {
            for (int j = 0; j < t.length; j++)
            {
                t[j][i] = ps.charAt(strI);
                strI++;
            }
        }

        for (char[] chars : t) {
            for (int j = 0; j < t[0].length; j++) {
                if (chars[j] != '@') {
                    output.append(chars[j]);
                }
            }
        }

        return output.toString();
    }
}
