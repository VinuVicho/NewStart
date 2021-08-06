package org.vinuvicho.leetcode.med;

public class TaskEight {
    public static void main(String[] args) {
        System.out.println(myAoti("283472332"));
    }
     static int myAoti(String s) {
        final char[] a = s.toCharArray();
        Boolean symbol = null;
        Integer result = null;
        for (char c : a) {
            if (c < 58 && c > 47) {
                final byte i = (byte) Character.getNumericValue(c);
                if (result == null) result = 0;
                if (symbol == null) symbol = true;
                if (result > 214748364 || (result >= 214748364 && (symbol && i > 7 || !symbol && i > 8))) {
                    return (symbol) ? 2147483647 : -2147483648;
                }
                result = result * 10 + i;
            } else if (result == null && symbol == null) {
                if (c == 43) symbol = true;
                else if (c == 45) symbol = false;
                else //noinspection StatementWithEmptyBody
                    if (c == 32) ;
                else break;
            } else break;
        }
        return  (result == null) ? 0 : (symbol == null || symbol) ? result : -result;
    }
}
