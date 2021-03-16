package com.company;

import java.util.Arrays;

public class SubsetGivenDifference {

    static int[][] cache;

    static int countSubsetSum(int[] arr, int sum, int n) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        if (cache[n][sum] != -1) return cache[n][sum];
        if (arr[n - 1] > sum)
            cache[n][sum] = countSubsetSum(arr, sum, n - 1);
        else
            cache[n][sum] = countSubsetSum(arr, sum, n - 1) + countSubsetSum(arr, sum - arr[n - 1], n - 1);
        return cache[n][sum];
    }

    static int countSubsetSumIterative(int[] arr, int sum) {
        int[][] dp = new int[arr.length + 1][sum + 1];
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[arr.length][sum];
    }

    static int countSubSetGivenDiff(int[] arr, int difference) {
        int sum = Arrays.stream(arr).sum();
        int seed = sum + difference;
        if (seed % 2 != 0)
            return 0;
        else {
            cache = new int[arr.length + 1][seed / 2 + 1];
            for (int i = 0; i < cache.length; i++) {
                for (int j = 0; j < cache[0].length; j++) {
                    cache[i][j] = -1;
                }
            }
            // return countSubsetSum(arr, seed / 2, arr.length);
            return countSubsetSumIterative(arr, seed / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(countSubSetGivenDiff(new int[]{1, 1, 2, 3}, 1));
    }
}
