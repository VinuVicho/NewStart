package org.vinuvicho.labs.protection.three;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RSA {

    private static final int p = 17;
    private static final int q = 37;
    private static final int e = 13;
    private static final BigInteger N = BigInteger.valueOf(p * q);
    private static final BigInteger phi = BigInteger.valueOf((p - 1) * (q - 1));
    private static final BigInteger d = BigInteger.valueOf(e).modInverse(phi);
    private static final String message = "РЕЙС56";
    private static final String encryptedMessage = "69, 1, 427, 225, 392, 406";

    public static void main(String[] args) {
        HashMap<Character, Integer> map = createMap();
        List<BigInteger> encrypted = encryptMessage(map, e, N);
        System.out.println("Оригінальне повідомлення: " + message);
        System.out.println("Зашифроване повідомлення: " + encrypted + "\n");
        String decrypted = decryptMessage(map, d, N);
        System.out.println("Зашифроване повідомлення: " + encryptedMessage);
        System.out.println("Розшифроване повідомлення: " + decrypted);
    }

    private static HashMap<Character, Integer> createMap() {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('А', 1); map.put('Б', 2); map.put('В', 3); map.put('Г', 4);  map.put('Д', 5); map.put('Е', 6); map.put('Ї', 7);
        map.put('Ж', 8); map.put('З', 9); map.put('И', 10);  map.put('Й', 11); map.put('К', 12); map.put('Л', 13);
        map.put('М', 14); map.put('Н', 15); map.put('О', 16); map.put('П', 17); map.put('Р', 18); map.put('С', 19);
        map.put('Т', 20); map.put('У', 21); map.put('Ф', 22); map.put('Х', 23); map.put('Ц', 24); map.put('Ч', 25); map.put('Ш', 26);
        map.put('Щ', 27); map.put('Є', 28); map.put('Ґ', 29); map.put('Ь', 30); map.put('І',31); map.put('Ю', 32);
        map.put('Я', 33); map.put('_', 34); map.put('0', 35); map.put('1', 36); map.put('2', 37); map.put('3', 38); map.put('4', 39); map.put('5', 40);
        map.put('6', 41); map.put('7', 42); map.put('8', 43); map.put('9', 44);
        return map;
    }

    private static List<BigInteger> encryptMessage(HashMap<Character, Integer> map, int e, BigInteger N) {
        BigInteger E = BigInteger.valueOf(e);
        return RSA.message.chars()
                .mapToObj(c -> BigInteger.valueOf(map.get((char) c)))
                .map(m -> m.modPow(E, N))
                .collect(Collectors.toList());
    }

    private static String decryptMessage(HashMap<Character, Integer> map, BigInteger d, BigInteger N) {
        List<BigInteger> encrypted = List.of(RSA.encryptedMessage.split(","))
                .stream()
                .map(String::trim)
                .map(BigInteger::new)
                .collect(Collectors.toList());

        HashMap<Integer, Character> reverseMap = new HashMap<>();
        map.forEach((key, value) -> reverseMap.put(value, key));

        return encrypted.stream()
                .map(c -> c.modPow(d, N))
                .map(i -> reverseMap.get(i.intValue()))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}