package org.vinuvicho.labs.protection.two;

import java.util.Scanner;

public class PlayfairDecryptWithoutKeyword {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Веедіть шифр для дешифрування: ");
        String ciphertext = input.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        char[][] matrix = createMatrix();
        char[][] decryptionMatrix = createDecryptionMatrix(matrix);

        String plaintext = decryptMessage(ciphertext, decryptionMatrix);

        System.out.println("Дешифроване повідомлення: " + plaintext);
    }

    public static char[][] createMatrix() {
        char[][] matrix = new char[5][5];
        String letters = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = letters.charAt(index);
                index++;
            }
        }
        return matrix;
    }

    public static char[][] createDecryptionMatrix(char[][] matrix) {
        char[][] decryptionMatrix = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                decryptionMatrix[i][j] = matrix[j][i];
            }
        }
        return decryptionMatrix;
    }

    public static String decryptMessage(String ciphertext, char[][] decryptionMatrix) {
        StringBuilder plaintext = new StringBuilder();

        ciphertext = ciphertext.replaceAll("J", "I");

        // Decrypt pairs of letters
        for (int i = 0; i < ciphertext.length(); i += 2) {
            char c1 = ciphertext.charAt(i);
            char c2 = ciphertext.charAt(i + 1);

            int r1 = 0, c1Index = 0, r2 = 0, c2Index = 0;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (decryptionMatrix[j][k] == c1) {
                        r1 = j;
                        c1Index = k;
                    }
                    if (decryptionMatrix[j][k] == c2) {
                        r2 = j;
                        c2Index = k;
                    }
                }
            }

            char newC1, newC2;

            if (r1 == r2) {
                newC1 = decryptionMatrix[r1][(c1Index + 4) % 5];
                newC2 = decryptionMatrix[r2][(c2Index + 4) % 5];
            } else if (c1Index == c2Index) {
                newC1 = decryptionMatrix[(r1 + 4) % 5][c1Index];
                newC2 = decryptionMatrix[(r2 + 4) % 5][c2Index];
            } else {
                newC1 = decryptionMatrix[r1][c2Index];
                newC2 = decryptionMatrix[r2][c1Index];
            }

            plaintext.append(newC1).append(newC2);
        }

        return plaintext.toString();
    }
}