package com.company;

import java.util.Arrays;

public class SubsetSum {
    static Boolean[][] cache;

    static boolean subsetSum(int[] numbers, int val, int n) {
        if (val == 0) return true;
        if (n == 0) return false;
        if (cache[n][val] != null) {
            return cache[n][val];
        }
        if (numbers[n - 1] <= val) {
            cache[n][val] = subsetSum(numbers, val - numbers[n - 1], n - 1) || subsetSum(numbers, val, n - 1);
        } else
            cache[n][val] = subsetSum(numbers, val, n - 1);
        return cache[n][val];
    }

    static boolean subsetSumIter(int[] numbers, int val) {
        boolean[][] t = new boolean[numbers.length + 1][val + 1];

        for (int i = 0; i < val + 1; i++) {
            t[0][i] = false;
        }
        for (int i = 0; i < numbers.length + 1; i++) {
            t[i][0] = true;
        }
        for (int i = 1; i < numbers.length + 1; i++) {
            for (int j = 1; j < val + 1; j++) {
                if (numbers[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - numbers[i - 1]] || t[i - 1][j];
                } else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[numbers.length][val];
    }

    static boolean equalSumPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 == 1) return false;
        int half = total / 2;
        cache = new Boolean[nums.length + 1][half + 1];
        return subsetSum(nums, half, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 8, 10, 1};
        int val = 31;
        cache = new Boolean[nums.length + 1][val + 1];
        System.out.println(subsetSum(nums, val, nums.length));
        System.out.println(equalSumPartition(new int[]{1, 5, 5, 11}));
        System.out.println(subsetSumIter(nums, val));
    }
}
