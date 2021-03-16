package com.company;

public class MatrixChainMultiplication {
    static int[][] cache;

    static int solve(int[] arr, int i, int j) {
        if (i >= j) return 0;
        if (cache[i][j] != 0) return cache[i][j];
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (temp < minCost)
                minCost = temp;
        }
        cache[i][j] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30, 40, 20, 50, 60, 56, 34, 23, 4, 56, 67, 78, 43, 12, 80, 67, 890, 653, 543};
        cache = new int[arr.length + 1][arr.length + 1];
        System.out.println(solve(arr, 1, arr.length - 1));
    }
}
