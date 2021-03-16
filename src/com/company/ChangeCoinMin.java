package com.company;

public class ChangeCoinMin {

    static int[][] cache;

    static int minCoins(int[] coins, int total, int n) {
        if (total == 0) return 0;
        if (n == 0) return Integer.MAX_VALUE - 1;
        if (cache[n][total] != 0) return cache[n][total];
        if (coins[n - 1] > total)
            cache[n][total] = minCoins(coins, total, n - 1);
        else
            cache[n][total] = Math.min(minCoins(coins, total, n - 1), 1 + minCoins(coins, total - coins[n - 1], n));
        return cache[n][total];
    }

    public static void main(String[] args) {
        int total = 5;
        int[] coins = {2};
        cache = new int[coins.length + 1][total + 1];
        int x = minCoins(coins, total, coins.length);
        System.out.println(x == Integer.MAX_VALUE - 1 ? -1 : x);
    }
}
