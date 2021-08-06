package org.vinuvicho.leetcode.easy;

import java.util.Arrays;

public class TaskOne {
     static int[] twoSum(int[] nums, int target) {
        for (short q = 0; true; q++)
            for (short w = (short) (q+1); w < nums.length; w++)
                if ((nums[q]+nums[w]) == target)
                    return new int[]{q, w};
    }

     public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
