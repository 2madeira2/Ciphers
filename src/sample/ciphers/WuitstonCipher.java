package sample.ciphers;

public class WuitstonCipher implements Cipher {
    @Override
    public String encrypt(String text, String key) {
        String alphabyteOne = "кларбвгдежзиймнопстуфхцчшщъыьэюя._,-";
        String alphabyteSec = "кларнетбвгджзиймопсуфхцчшщъыьэюя._,-";
        char[][] firstTable = new char[9][4];
        char[][] secondTable = new char[9][4];
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
        int coordnateIFirstLetter = 0;
        int coordnateJFirstLetter = 0;
        int coordinateISecondLetter = 0;
        int coordnateJSecondLetter = 0;
        String resultStr = "";
        char [] textArray = text.toCharArray();
        for(int k = 0; k < textArray.length; k+=2){
            for(int i = 0; i < firstTable.length; i++){
                for(int j = 0; j < firstTable[i].length; j++){
                    if(textArray[k] == firstTable[i][j]){
                        coordnateIFirstLetter = i;
                        coordnateJFirstLetter = j;
                    }
                }
                }
            for(int i = 0; i < secondTable.length; i++){
                for(int j = 0; j < secondTable[i].length; j++){
                    if(textArray[k+1] == secondTable[i][j]){
                        coordinateISecondLetter = i;
                        coordnateJSecondLetter = j;
                    }
                }
            }
            if(coordnateIFirstLetter == coordinateISecondLetter){
                System.out.println(firstTable[coordnateIFirstLetter][coordnateJSecondLetter]);
                System.out.println(secondTable[coordnateIFirstLetter][coordnateJFirstLetter]);
                resultStr += Character.toString(firstTable[coordnateIFirstLetter][coordnateJSecondLetter]) + Character.toString(secondTable[coordnateIFirstLetter][coordnateJFirstLetter]);
            }
            else {
                resultStr += Character.toString(secondTable[coordnateIFirstLetter][coordnateJSecondLetter]) + Character.toString(firstTable[coordinateISecondLetter][coordnateJFirstLetter]);
                System.out.println(secondTable[coordnateIFirstLetter][coordnateJSecondLetter]);
                System.out.println(firstTable[coordinateISecondLetter][coordnateJFirstLetter]);
//                прилетаю_шестого
            }
            }

        return resultStr;
        }


    @Override
    public String decrypt(String text, String key) {
        String resultStr = "";
        String alphabyteOne = "кларбвгдежзиймнопстуфхцчшщъыьэюя._,-";
        String alphabyteSec = "кларнетбвгджзиймопсуфхцчшщъыьэюя._,-";
        char[][] firstTable = new char[9][4];
        char[][] secondTable = new char[9][4];
        char letterOne = '0';
        char letterSec = '0';
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

        int coordnateIFirstLetter = 0;
        int coordnateJFirstLetter = 0;
        int coordinateISecondLetter = 0;
        int coordnateJSecondLetter = 0;
        char [] textArray = text.toCharArray();



            for (int k = 0; k < textArray.length; k += 2) {
                for(int i = 0; i < firstTable.length; i++){
                    for(int j = 0; j < firstTable[i].length; j++){
                        if(textArray[k] == firstTable[i][j]){
                            coordinateISecondLetter = i;
                            coordnateJSecondLetter = j;
                        }
                    }
                }
                for(int i = 0; i < secondTable.length; i++){
                    for(int j = 0; j < secondTable[i].length; j++){
                        if(textArray[k+1] == secondTable[i][j]){
                            coordnateIFirstLetter = i;
                            coordnateJFirstLetter = j;
                        }
                    }
                }
                if(coordnateIFirstLetter == coordinateISecondLetter){
                    letterOne = firstTable[coordnateIFirstLetter][coordnateJFirstLetter];
                    letterSec = secondTable[coordinateISecondLetter][coordnateJSecondLetter];
                    resultStr += Character.toString(letterOne) + Character.toString(letterSec);
                }
                else {
                    for (int i = 0; i < secondTable.length; i++) {
                        for (int j = 0; j < secondTable[i].length; j++) {
                            if (textArray[k] == secondTable[i][j]) {
                                coordnateIFirstLetter = i;
                                coordnateJSecondLetter = j;
                            }
                        }
                    }
                    for (int i = 0; i < firstTable.length; i++) {
                        for (int j = 0; j < firstTable[i].length; j++) {
                            if (textArray[k + 1] == firstTable[i][j]) {
                                coordinateISecondLetter = i;
                                coordnateJFirstLetter = j;
                            }
                        }
                    }

                    letterOne = firstTable[coordnateIFirstLetter][coordnateJFirstLetter];
                    letterSec = secondTable[coordinateISecondLetter][coordnateJSecondLetter];
                    resultStr += Character.toString(letterOne) + Character.toString(letterSec);
                }
//                прилетаю_шестого
            }
        return resultStr;
    }
}
