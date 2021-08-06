package org.vinuvicho.leetcode.easy;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[] {1,1,2,2,3}, 2));
    }
    static int removeElement(int[] nums, int val) {
        int a = 0;
        System.out.println(Arrays.toString(nums));
        for (int i : nums) {
            if (i != val) nums[a++] = i;
            System.out.println(Arrays.toString(nums));
        }
        return a;
    }
}
