package com.company;

public class CoinChanger {

    static long[][] cache;

    static long getWays(int[] coins, int total, int n) {
        if (total == 0) return 1;
        if (n == 0) return 0;
        if (cache[n][total] != 0) return cache[n][total];
        if (coins[n - 1] > total)
            cache[n][total] = getWays(coins, total, n - 1);
        else
            cache[n][total] = getWays(coins, total, n - 1) + getWays(coins, total - coins[n - 1], n);
        return cache[n][total];
    }

    static long getWaysIterative(int[] coins, int total) {
        long[][] dp = new long[coins.length + 1][total + 1];

        for (int i = 1; i <= total; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= total; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
            }
        }
        return dp[coins.length][total];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{16, 30, 9, 17, 40, 13, 42, 5, 25, 49, 7, 23, 1, 44, 4, 11, 33, 12, 27, 2, 38, 24, 28, 32, 14, 50};
        int total = 245;
        cache = new long[coins.length + 1][total + 1];
        System.out.println(getWays(coins, total, coins.length));
        System.out.println(getWaysIterative(coins, total));
    }
}
