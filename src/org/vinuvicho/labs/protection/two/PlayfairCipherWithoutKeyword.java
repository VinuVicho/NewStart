package org.vinuvicho.labs.protection.two;

import java.util.Scanner;

public class PlayfairCipherWithoutKeyword {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введіть текст англ для шифрування: ");
        String plaintext = input.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        char[][] matrix = createMatrix();

        String ciphertext = encryptMessage(plaintext, matrix);

        System.out.println("Зашифроване повідомлення: " + ciphertext);
    }

    public static char[][] createMatrix() {
        char[][] matrix = new char[5][5];
        String letters = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; // Нема літери J

        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = letters.charAt(index);
                index++;
            }
        }
        return matrix;
    }

    public static String encryptMessage(String plaintext, char[][] matrix) {
        StringBuilder ciphertext = new StringBuilder();

        plaintext = plaintext.replaceAll("J", "I");

        // Добавити Х якщо непарна кількість символів
        if (plaintext.length() % 2 != 0) {
            plaintext += "X";
        }

        for (int i = 0; i < plaintext.length(); i += 2) {
            char c1 = plaintext.charAt(i);
            char c2 = plaintext.charAt(i+1);

            int r1 = 0, c1Index = 0, r2 = 0, c2Index = 0;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (matrix[j][k] == c1) {
                        r1 = j;
                        c1Index = k;
                    }
                    if (matrix[j][k] == c2) {
                        r2 = j;
                        c2Index = k;
                    }
                }
            }

            char newC1, newC2;

            // В тому самому рядку
            if (r1 == r2) {
                newC1 = matrix[r1][(c1Index + 1) % 5];
                newC2 = matrix[r2][(c2Index + 1) % 5];
            }
            // в тому самому стовпчику
            else if (c1Index == c2Index) {
                newC1 = matrix[(r1 + 1) % 5][c1Index];
                newC2 = matrix[(r2 + 1) % 5][c2Index];
            }
            // в різних рядках/стовпчиках
            else {
                newC1 = matrix[r1][c2Index];
                newC2 = matrix[r2][c1Index];
            }

            ciphertext.append(newC1);
            ciphertext.append(newC2);
        }

        return ciphertext.toString();
    }

}