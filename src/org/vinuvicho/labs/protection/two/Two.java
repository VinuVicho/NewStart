package org.vinuvicho.labs.protection.two;
import java.util.HashMap;

public class Two {

    public static void main(String[] args) {
        //для шифру
        String gamma = "БОГУСЛАВ";
        String word = "ГРОВКМАДА_150_КГ";
        encrypt(gamma,word);

        //дешифр
        gamma = "ДЕРЖИКРАЙ";
        word = "Щ32071ФИТЛПИТШЩИК";
        decrypt(gamma,word);
    }

    public static void encrypt(String gamma, String word) {
        HashMap<Character, Integer> map = getHashMap();
        int[] gammaNumbers = new int[gamma.length()];
        for (int i = 0; i < gamma.length(); i++) {
            char c = gamma.charAt(i);
            gammaNumbers[i] = map.get(c);
        }

        int[] wordNumbers = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int cNumber = map.get(c);
            int gammaNumber = gammaNumbers[i % gamma.length()];
            int encryptedNumber = (cNumber + gammaNumber) % map.size();
            wordNumbers[i] = encryptedNumber;
        }

        StringBuilder encryptedWord = new StringBuilder();
        for (int number : wordNumbers) {
            char c = ' ';
            for (char key : map.keySet()) {
                if (map.get(key) == number) {
                    c = key;
                    break;
                }
            }
            encryptedWord.append(c);
        }

        System.out.println("Зашифроване повідомлення: " + encryptedWord);
    }

    public static void decrypt(String gamma, String encryptedWord) {
        HashMap<Character, Integer> map = getHashMap();
        int[] gammaNumbers = new int[gamma.length()];
        for (int i = 0; i < gamma.length(); i++) {
            char c = gamma.charAt(i);
            gammaNumbers[i] = map.get(c);
        }
        gammaNumbers = new int[gamma.length()];
        for (int i = 0; i < gamma.length(); i++) {
            char c = gamma.charAt(i);
            gammaNumbers[i] = map.get(c);
        }

        int[] encryptedNumbers = new int[encryptedWord.length()];
        for (int i = 0; i < encryptedWord.length(); i++) {
            char c = encryptedWord.charAt(i);
            int cNumber = map.get(c);
            int gammaNumber = gammaNumbers[i % gamma.length()];
            int decryptedNumber = (cNumber - gammaNumber + map.size()) % map.size();
            encryptedNumbers[i] = decryptedNumber;
        }

        // конвертовані цифри назад до букв
        StringBuilder decryptedWord = new StringBuilder();
        for (int number : encryptedNumbers) {
            char c = ' ';
            for (char key : map.keySet()) {
                if (map.get(key) == number) {
                    c = key;
                    break;
                }
            }
            decryptedWord.append(c);
        }

        System.out.println("Decrypted word: " + decryptedWord);
    }

    private static HashMap<Character, Integer> getHashMap(){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('А', 1); map.put('Б', 2); map.put('В', 3); map.put('Г', 4); map.put('Ґ', 5); map.put('Д', 6); map.put('Е', 7); map.put('Є', 8);
        map.put('Ж', 9); map.put('З', 10); map.put('И', 11); map.put('І', 12); map.put('Ї', 13); map.put('Й', 14); map.put('К', 15); map.put('Л', 16);
        map.put('М', 17); map.put('Н', 18); map.put('О', 19); map.put('П', 20); map.put('Р', 21); map.put('С', 22); map.put('Т', 23); map.put('У', 24);
        map.put('Ф', 25); map.put('Х', 26); map.put('Ц', 27); map.put('Ч', 28); map.put('Ш', 29); map.put('Щ', 30); map.put('Ь', 31); map.put('Ю', 32);
        map.put('Я', 33); map.put('_', 34); map.put('0', 35); map.put('1', 36); map.put('2', 37); map.put('3', 38); map.put('4', 39); map.put('5', 40);
        map.put('6', 41); map.put('7', 42); map.put('8', 43); map.put('9', 44);
        return map;
    }
}
