package org.vinuvicho.labs.protection.one;
import java.util.Arrays;

public class TranspositionCipher {
    private String text;
    private String textEncrypt;
    private String textDecrypt;
    private static int n = 5;
    private static int m;

    TranspositionCipher(String text) {
        this.text = text;
        m = (int)Math.ceil((double)this.text.length() / (double)n);
        this.text = checkText(this.text);
        this.textEncrypt = encrypt(this.text.toLowerCase());
        this.textDecrypt = decrypt(this.textEncrypt);
        writeResult();
    }

    public void writeResult() {
        System.out.println("\tШифр одиночної перестановки:");
        System.out.println(" Текст > " + this.text);
        System.out.println("Ключ: розмір таблиці > " + m + " x " + n);
        System.out.println(" Зашифрований текст > " + this.textEncrypt);
        System.out.println(" Дешифрований текст >" + this.textDecrypt);
        System.out.println();
    }

    public String getEncrypt() {
        return this.textEncrypt;
    }

    public String getDecrypt() {
        return this.textDecrypt;
    }

    private static String checkText(String text) {
        String str = text;
        if (text.length() % n != 0) {
            for(int i = 0; i < n - text.length() % n; ++i) {
                str = str + " ";
            }
        }

        return str;
    }

    public static String encrypt(String str) {
        int k = 0;
        char[] msg = new char[str.length()];
        msg = str.toCharArray();
        char[][] temp = new char[m][n];

        int i;
        for(int j = 0; j < m; ++j) {
            for(i = 0; i < n; ++i) {
                temp[j][i] = msg[k];
                ++k;
            }
        }

//        System.out.println("Таблиця перестановки: \n" + Arrays.deepToString(temp));
        String ct = "";

        for(i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                ct = ct + temp[j][i];
            }
        }

        return ct;
    }

    public static String decrypt(String str) {
        int k = 0;
        char[] msg = new char[str.length()];
        msg = str.toCharArray();
        char[][] temp = new char[m][n];

        int i;
        for( i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                temp[j][i] = msg[k];
                ++k;
            }
        }

        System.out.println("Таблиця перестановки: \n" + Arrays.deepToString(temp));
        String pt = "";

        for(i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                pt = pt + temp[i][j];
            }
        }

        return pt;
    }
}