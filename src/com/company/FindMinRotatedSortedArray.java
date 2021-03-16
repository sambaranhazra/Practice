package com.company;

import java.util.Arrays;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums, return the minimum element of this array.
 */
public class FindMinRotatedSortedArray {
    static public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int guess = (low + high) / 2;
            if (nums[guess] > nums[high])
                low = guess + 1;
            else {
                high = guess;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4, 5, 6, 7, -2, -1, 0, 1, 2, 3}));
    }
}
