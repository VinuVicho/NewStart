package org.vinuvicho.leetcode.easy;

public class ReserveInteger {
    public static void main(String[] args) {
        System.out.println(reserve(-2147483412));
    }
     static int reserve(int x) {
        int result = 0;
        while (x != 0) {
            if ((result > 214748364 && x < 8) || (result < -214748364 && x != -9)) return 0;
            result = result * 10 + x%10;
            x = x/10;
        }
        return result;
    }
}
