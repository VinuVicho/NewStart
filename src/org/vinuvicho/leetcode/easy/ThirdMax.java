package org.vinuvicho.leetcode.easy;

public class ThirdMax {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2,2,3,1}));
    }
    static int thirdMax(int[] nums) {
        Integer[] result = {null, null, null}; //highest,  second , third
        for (int num : nums)
            if ((result[2] == null || num > result[2]) && (result[1] == null || num != result[1])
                    && (result[0] == null || num != result[0]))
                if (result[1] == null || num > result[1])
                    if (result[0] == null || num > result[0]) {
                        result[2] = result[1];
                        result[1] = result[0];
                        result[0] = num;
                    } else {
                        result[2] = result[1];
                        result[1] = num;
                    }
                else result[2] = num;
        return (result[2] == null) ? result[0] : result[2];
    }
}
