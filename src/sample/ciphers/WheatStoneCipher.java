package sample.ciphers;

import javafx.util.Pair;

public class WheatStoneCipher implements Cipher{

    private final String _message;
    private final String _key;
    private char[][] firstTable;
    private char[][] secondTable;

    public WheatStoneCipher(String message, String key)
    {
        this._message = message;
        this._key = key;
    }

    private void initTables()
    {
        String[] parameters = this._key.split("\n");
        int rows = Integer.parseInt(parameters[0]);
        int columns = Integer.parseInt(parameters[1]);
        String alphabyteOne = parameters[2];
        String alphabyteSec = parameters[3];
        for (String par : parameters) System.out.println(par);
        char[][] firstTable = new char[rows][columns];
        char[][] secondTable = new char[rows][columns];
        int counter = 0;
        for (int i = 0; i < firstTable.length; i++) {
            for (int j = 0; j < firstTable[i].length; j++) {
                firstTable[i][j] = alphabyteOne.toCharArray()[counter];
                counter++;
            }
        }
        counter = 0;
        for (int i = 0; i < secondTable.length; i++) {
            for (int j = 0; j < secondTable[i].length; j++) {
                secondTable[i][j] = alphabyteSec.toCharArray()[counter];
                counter++;
            }
        }
        this.firstTable = firstTable;
        this.secondTable = secondTable;
    }

    private static Pair<Integer, Integer> getLetterCoordinates(char[][] matrix, char letter)
    {
        int rowIndex = 0;
        int columnIndex = 0;

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] == letter)
                {
                    rowIndex = i;
                    columnIndex = j;
                    break;
                }
            }
        }

        return new Pair<>(rowIndex, columnIndex);
    }

    private static char[][] getBigramsFromMessage(String message)
    {
        String augmentedMessage = message + (message.length() % 2 != 0 ? " " : "");
        char [][] result = new char[augmentedMessage.length() / 2][2];

        for (int i = 0; i < augmentedMessage.length(); i++)
        {
            result[i / 2][i % 2] = augmentedMessage.toCharArray()[i];
        }

        return result;
    }

    private static String getMessageFromBigrams(char[][] bigrams)
    {
        StringBuilder result = new StringBuilder();

        for (char[] bigram : bigrams) {
            result.append(bigram[0]);
            result.append(bigram[1]);
        }

        return result.toString();
    }

    @Override
    public String encrypt()
    {
        initTables();
        char [][] bigrams = getBigramsFromMessage(_message);
        char[][] result = new char[bigrams.length][bigrams[0].length];

        for (int m = 0; m < bigrams.length; m++)
        {
            Pair<Integer, Integer> CoordinatesFirstLetter;
            CoordinatesFirstLetter = getLetterCoordinates(firstTable, bigrams[m][0]);
            int firstLetterI = CoordinatesFirstLetter.getKey();
            int firstLetterJ = CoordinatesFirstLetter.getValue();
            Pair<Integer, Integer> CoordinatesSecondLetter;
            CoordinatesSecondLetter = getLetterCoordinates(secondTable, bigrams[m][1]);
            int secondLetterI = CoordinatesSecondLetter.getKey();
            int secondLetterJ = CoordinatesSecondLetter.getValue();

            if (firstLetterI == secondLetterI)
            {
                result[m][0] = secondTable[firstLetterI][firstLetterJ];
                result[m][1] = firstTable[secondLetterI][secondLetterJ];
            }
            else
            {
                result[m][0] = secondTable[firstLetterI][secondLetterJ];
                result[m][1] = firstTable[secondLetterI][firstLetterJ];
            }
        }

        return getMessageFromBigrams(result);

    }
    @Override
    public String decrypt()
    {

        initTables();
        char[][] bigrams = getBigramsFromMessage(_message);
        char[][] result = new char[bigrams.length][bigrams[0].length];

        for (int i = 0; i < bigrams.length; i++)
        {
            Pair<Integer, Integer> CoordinatesFirstLetter;
            CoordinatesFirstLetter = getLetterCoordinates(secondTable, bigrams[i][0]);
            int firstLetterI = CoordinatesFirstLetter.getKey();
            int firstLetterJ = CoordinatesFirstLetter.getValue();
            Pair<Integer, Integer> CoordinatesSecondLetter;
            CoordinatesSecondLetter = getLetterCoordinates(firstTable, bigrams[i][1]);
            int secondLetterI = CoordinatesSecondLetter.getKey();
            int secondLetterJ = CoordinatesSecondLetter.getValue();

            if (firstLetterI == secondLetterI)
            {
                result[i][0] = firstTable[firstLetterI][firstLetterJ];
                result[i][1] = secondTable[secondLetterI][secondLetterJ];
            }
            else
            {
                result[i][0] = firstTable[firstLetterI][secondLetterJ];
                result[i][1] = secondTable[secondLetterI][firstLetterJ];
            }
        }

        return getMessageFromBigrams(result);
    }
}
