package com.company;

public class MaxSum {
    public static int maxSubsetSum(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = Math.max(0, nums[0]);
        dp[2] = Math.max(0, nums[1]);
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(0, Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]));
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        System.out.println(maxSubsetSum(new int[]{8006, -3505, -2450, -2399, -3423, 8968}));
    }
}
