package org.vinuvicho.labs.protection.one;
import java.io.PrintStream;
import java.util.Arrays;

public class ColumnarTranspositionCipher {
    private String text;
    private String textEncrypt;
    private String textDecrypt;
    public static String selectedKey;
    public static char[] sortedKey;
    public static int[] sortedKeyPos;

    ColumnarTranspositionCipher(String text, String Key) {
        this.text = text;
        selectedKey = Key;
        sortedKeyPos = new int[selectedKey.length()];
        sortedKey = selectedKey.toCharArray();
        System.out.println("\tШифр одиночної перестановки за ключовим словом:");
        System.out.println(" Текст > " + text);
        System.out.println(" Ключ > " + selectedKey);
        this.textEncrypt = encrypt(this.text.toLowerCase(), selectedKey);
        System.out.println(" Зашифрований текст >" + this.textEncrypt);
        System.out.println(" Зашифрований текст у 16вому представленні >" + stringToHex(this.textEncrypt));
        this.textDecrypt = decrypt(this.textEncrypt, selectedKey);
        System.out.println(" Дешифрований текст >" + this.textDecrypt);
        System.out.println();
    }

//    public void writeResult() {
//        System.out.println("\tШифр одиночної перестановки за ключовим словом:");
//        System.out.println(" Текст > " + this.text);
//        System.out.println(" Ключ > " + selectedKey);
//        System.out.println(" Зашифрований текст >" + this.textEncrypt);
//        System.out.println(" Дешифрований текст >" + this.textDecrypt);
//        System.out.println();
//    }

//    public String getEncrypt() {
//        return this.textEncrypt;
//    }
//
//    public String getDecrypt() {
//        return this.textDecrypt;
//    }

    public static String encrypt(String plainText, String selectedKey) {
        System.out.println("\nПроцес шифрування повідомлення..");
        char[] orginalKey = selectedKey.toCharArray();
        doProcessOnKey();
        int row = plainText.length() / selectedKey.length();
        int extrabit = plainText.length() % selectedKey.length();
        int exrow = extrabit == 0 ? 0 : 1;
        boolean rowtemp = true;
        int coltemp = -1;
        int totallen = (row + exrow) * selectedKey.length();
        char[][] pmat = new char[row + exrow][selectedKey.length()];
        char[] encry = new char[totallen];
        boolean tempcnt = true;
        row = 0;

        int i;
        for(i = 0; i < totallen; ++i) {
            ++coltemp;
            if (i < plainText.length()) {
                if (coltemp == selectedKey.length()) {
                    ++row;
                    coltemp = 0;
                }

                pmat[row][coltemp] = plainText.charAt(i);
            } else {
                pmat[row][coltemp] = '*';
            }
        }

        PrintStream var10000 = System.out;
        String var10001 = Arrays.toString(orginalKey);
        var10000.println("Таблиця до перестановки: \n" + var10001 + "\n" + Arrays.deepToString(pmat));
        int len = -1;

        for(i = 0; i < selectedKey.length(); ++i) {
            int k;
            for(k = 0; k < selectedKey.length() && i != sortedKeyPos[k]; ++k) {
            }

            for(int j = 0; j <= row; ++j) {
                ++len;
                encry[len] = pmat[j][k];
            }
        }

        var10000 = System.out;
        var10001 = Arrays.toString(sortedKey);
        var10000.println("Таблиця після перестановки: \n" + var10001 + "\n" + Arrays.toString(sortedKeyPos) + "\n" + Arrays.toString(encry));
        String p1 = new String(encry);
        return new String(p1);
    }

    public static String decrypt(String s, String selectedKey) {
        System.out.println("\nПроцес дешифрування повідомлення..");
        char[] key = selectedKey.toCharArray();
        char[] encry = s.toCharArray();
        doProcessOnKey();
        int row = s.length() / selectedKey.length();
        char[][] pmat = new char[row][selectedKey.length()];
        int tempcnt = -1;
        PrintStream var10000 = System.out;
        String var10001 = Arrays.toString(key);
        var10000.println("Таблиця до перестановки: \n" + var10001 + "\n" + Arrays.toString(encry));

        int i;
        int j;
        int k;
        for(i = 0; i < selectedKey.length(); ++i) {
            for(k = 0; k < selectedKey.length() && i != sortedKeyPos[k]; ++k) {
            }

            for(j = 0; j < row; ++j) {
                ++tempcnt;
                pmat[j][k] = encry[tempcnt];
            }
        }

        var10000 = System.out;
        var10001 = Arrays.toString(sortedKey);
        var10000.println("Таблиця після перестановки: \n" + var10001 + "\n" + Arrays.toString(sortedKeyPos) + "\n" + Arrays.deepToString(pmat));
        char[] p1 = new char[row * selectedKey.length() + 1];
        k = 0;

        for(i = 0; i < row; ++i) {
            for(j = 0; j < selectedKey.length(); ++j) {
                if (pmat[i][j] != '*') {
                    p1[k] = pmat[i][j];
                    ++k;
                }
            }
        }

        p1[k] = 0;
        return new String(p1);
    }

    public static void doProcessOnKey() {
        char[] orginalKey = selectedKey.toCharArray();

        int i;
        int j;
        for(i = 0; i < selectedKey.length(); ++i) {
            int min = i;

            for(j = i; j < selectedKey.length(); ++j) {
                if (sortedKey[min] > sortedKey[j]) {
                    min = j;
                }
            }

            if (min != i) {
                char temp = sortedKey[i];
                sortedKey[i] = sortedKey[min];
                sortedKey[min] = temp;
            }
        }

        for(i = 0; i < selectedKey.length(); ++i) {
            for(j = 0; j < selectedKey.length(); ++j) {
                if (orginalKey[i] == sortedKey[j]) {
                    sortedKeyPos[i] = j;
                }
            }
        }

    }

    public static String stringToHex(String input) {
        StringBuilder hexString = new StringBuilder();
        char[] charArray = input.toCharArray();
        for (char ch : charArray) {
            String hex = Integer.toHexString(ch);
            hexString.append(hex);
        }
        return hexString.toString();
    }
}