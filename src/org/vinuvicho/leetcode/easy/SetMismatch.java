package org.vinuvicho.leetcode.easy;

/**
 * 645. Set Mismatch
 * <p>
 * You have a set of integers s, which originally contains all the numbers from 1 to n.
 * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 * <p>
 * You are given an integer array nums representing the data status of this set after the error.
 * <p>
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 */
public class SetMismatch {
    //this one bad
    public int[] findErrorNums(int[] nums) {
        int[] result = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            for (int a = i + 1; a < nums.length && result[0] == 0; a++) {
                if (nums[i] == nums[a]) {
                    result[0] = nums[i];
                    break;
                }
            }

            if (nums[i] != i + 1) {
                boolean has = false;
                for (int num : nums) {
                    if (num == i + 1) {
                        has = true;
                        break;
                    }
                }
                if (!has) result[1] = i + 1;

            }
        }
        return result;
    }
}
