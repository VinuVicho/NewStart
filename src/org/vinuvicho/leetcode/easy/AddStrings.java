package org.vinuvicho.leetcode.easy;

import java.util.ArrayList;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("1112", "0"));
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        ArrayList<Character> preResult = new ArrayList<Character>();
        short l1 = (short) num1.length();
        short l2 = (short) num2.length();

        if (l2 > l1) {
            String q = num1;
            num1 = num2;
            num2 = q;
            l1 = (short) num1.length();
            l2 = (short) num2.length();
        }
        short difference = (short) (l1-l2);
        boolean ten = false;
        for (int i = l2-1; i > -1; i--) {
            short a = (short) (((short) num1.charAt(i+difference)-48) + ((short) num2.charAt(i)-48));
            if (ten) {
                a++;
                ten = false;
            }
            if (a > 9) {
                ten = true;
                a -= 10;
            }
            preResult.add(0, (char) (a+48));
        }
        for (int i = l1 - l2 - 1; i > -1; i--){
            short a = (short) (num1.charAt(i)-48);
            if (ten) {
                a++;
                ten = false;
            }
            if (a > 9) {
                ten = true;
                a -= 10;
            }
            preResult.add(0, (char) (a+48));
        }
        if (ten) preResult.add(0, '1');
        for (Character character : preResult) result.append(character);
        return result.toString();
    }
}
