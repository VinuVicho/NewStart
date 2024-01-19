package org.vinuvicho.leetcode.easy;

import lombok.NoArgsConstructor;

/**
 * Task 1287
 * Given an integer array sorted in non-decreasing order,
 * there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
 */
@NoArgsConstructor
public class FindSpecialInteger {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 6, 6, 7, 10, 10, 10};
    }

    public int findSpecialInteger(int[] arr) {
        int count = 0;
        int highestNumber = 0;
        int highestCount = arr.length /4;
        int number = -1;
        for (int i = 0; i < arr.length; i++) {
            if (number == arr[i]) {
                count++;
            } else {
                if (count > highestCount) {
                    highestNumber = number;
                    highestCount = count;
                }
                count = 1;
                number = arr[i];
            }
        }
        if (count > highestCount) {
            return number;
        }
        return highestNumber;
    }
}
