package org.vinuvicho.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class TruncateSentence {
    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
    }

    static String truncateSentence(String s, int k) {
        String[] q = s.split(" ");
        StringBuilder r = new StringBuilder(q[0]);
        for (int i = 1; i < k; i++)
            r.append(" ").append(q[i]);
        return r.toString();
    }
}
