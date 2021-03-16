package com.company;

import java.util.Arrays;

public class RotatedArraySearch {
    static public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int low = 0;
        int high = nums.length;
        int mid = -1;
        while (low < high && (nums[low] > nums[high - 1])) {
            mid = (low + high) / 2;
            if (nums[mid] < nums[low])
                high = mid;
            else
                low = mid;
        }
        if (mid != -1) {
            if (nums[0] > target) {
                int i = binarySearch(Arrays.copyOfRange(nums, mid, nums.length), target);
                return i >= 0 ? mid + i : i;
            } else {
                return binarySearch(Arrays.copyOfRange(nums, 0, mid), target);
            }
        } else {
            return binarySearch(nums, target);
        }
    }

    private static int binarySearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 1, 2, 3}, 3));
    }
}
