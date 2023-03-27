package org.vinuvicho.leetcode.hard;

public class PalindromePatiTwo {
    public static void main(String[] args) {
        System.out.println(minCut("ab") + " 1");
        System.out.println(minCut("aa") + " 0");
        System.out.println(minCut("cbbbcc") + " 1");
        System.out.println(minCut("qcbbbcc")+ " 2");
        System.out.println(minCut("aabvuvb")+ " 1");
        System.out.println(minCut("aaabaa")+ " 1");
        System.out.println(minCut("abaaaaabba")+ " 2");
    }

    static int minCutTry(String s) {
        short resultOne = -1;
        {
            int startIndex = 0;
            while (startIndex < s.length()) {
                int index = s.length() - 1;
                int end = index;
                int start = startIndex;
                while (end >= start) {
                    if (s.charAt(end) == s.charAt(start)) start++;
                    else {
                        if (index != end) {
                            end = index;
                            start = startIndex;
                        }
                        index--;
                    }
                    end--;
                }
                startIndex = index + 1;
                resultOne++;
            }
        }
        short resultTwo = -1;
        {
            int endIndex = s.length() -1;
            while (endIndex > -1) {
                int index = 0;
                int start = index;
                int end = endIndex;
                while (start <= end) {
                    if (s.charAt(start) == s.charAt(end)) end--;
                    else {
                        if (index != start) {
                            start = index;
                            end = endIndex;
                        }
                        index++;
                    }
                    start++;
                }
                endIndex = index - 1;
                resultTwo++;
            }
        }
        if (resultOne < resultTwo) return resultOne;
        return resultTwo;
    }
    //Answer
    static int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int[] min = new int[len];
        for (int i = 0; i < len; i++) {
            min[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    min[i] = j == 0 ? 0 : Math.min(min[i], min[j-1] + 1);
                }
            }
        }
        return min[len-1];
    }
}
