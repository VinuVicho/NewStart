package org.vinuvicho.leetcode.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsTwo {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1,2,2,3}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(Arrays.stream(nums).boxed().collect(java.util.stream.Collectors.toList()));
        for (byte i = 1; i < nums.length; i++)
            for (byte a = 0; a < nums.length; a++) {
                if (nums.length < a+i) continue;
                ArrayList<Integer> toAdd = new ArrayList<>();
                addNumber(nums, toAdd, i, a, result);
            }
        return result;
    }
    public static void addNumber(int[] nums, ArrayList<Integer> toAdd, int i, int index,
                                 List<List<Integer>> result) {
        if (i == 1) {
            toAdd.add(nums[index]);
            Collections.sort(toAdd);
            for (List<Integer> integers : result) {
                if (integers.equals(toAdd)) return;
            }
            result.add(toAdd);
        }
        else {
            toAdd.add(nums[index]);
            for (byte q = 1; q < nums.length-index; q++) {
                ArrayList<Integer> newAdd = new ArrayList<>(toAdd);
                addNumber(nums, newAdd, i-1, index+q, result);
            }
        }
    }
}
