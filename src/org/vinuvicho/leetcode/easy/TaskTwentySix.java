package org.vinuvicho.leetcode.easy;

import java.util.Arrays;
import java.util.TreeSet;

public class TaskTwentySix {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,2,2,3}));
    }
    static int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) set.add(num);
        int a = set.size();
        for (int i = 0; i < a; i++){
            if (set.first() != null) nums[i] = set.pollFirst();
        }
        return a;
    }
}
