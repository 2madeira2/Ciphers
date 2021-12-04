package sample.ciphers;
import java.util.HashMap;
import java.util.Map;

public class PolybianCipher implements Cipher {

    private final Map<Character, String> table;

    private final char[][] genericAlphabet = {
            {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж','('},
            {'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О','1'},
            {'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц','2'},
            {'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю','3'},
            {'Я', ' ', ',', '.', 'A', 'B', 'C', 'D','4'},
            {'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L','5'},
            {'M', 'N', 'O', 'P', 'Q', 'R', 'Є', 'Ї','6'},
            {'S', 'T', 'U', 'V', 'W', 'X', 'Ґ', 'І','7'},
            {'Y', 'Z', '?', '!', '@', '&', ')', '0','8'}
    };


    private final int length = genericAlphabet.length * genericAlphabet.length;

    public PolybianCipher() {
        this.table = new HashMap<>(this.length);
        for (int i = 0; i < genericAlphabet.length; i++) {
            for (int j = 0; j < genericAlphabet[i].length; j++) {
                table.put(genericAlphabet[i][j], "" + (i + 1) + (j + 1));
            }
        }
    }



    @Override
    public String encrypt(String text, String key) {
        if (text.isEmpty()) {
            return null;
        }

        StringBuilder cipher = new StringBuilder(this.length * 2);

        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            String num = table.get(c);
            cipher.append(num);
        }
        return cipher.toString();
    }

    @Override
    public String decrypt(String text, String key) {
        if (text.isEmpty()) {
            return null;
        }

        StringBuilder decodeText = new StringBuilder(text.length() / 2);

        for (int i = 0; i < text.length(); i = i + 2) {
            int j = i + 1;

            char c1 = text.charAt(i);
            char c2 = text.charAt(j);

            int firstNum = Character.getNumericValue(c1) - 1;
            int secondNum = Character.getNumericValue(c2) - 1;

            if (firstNum > genericAlphabet.length - 1 || firstNum < 0 || secondNum > genericAlphabet.length - 1 || secondNum < 0) {
                throw new IllegalArgumentException();
            }

            decodeText.append(genericAlphabet[firstNum][secondNum]);
        }

        return decodeText.toString();
    }
}
