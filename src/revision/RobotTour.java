package revision;

import java.math.BigInteger;

public class RobotTour {
    static BigInteger[][] cache;

    static BigInteger total(int i, int j) {
        if (i == 0 || j == 0) return BigInteger.ZERO;
        if (i == 1 && j == 1) return BigInteger.ONE;
        if (cache[i][j] != null) return cache[i][j];
        return cache[i][j] = total(i - 1, j).add(total(i, j - 1));
    }

    static BigInteger totalIterative(int m, int n) {
        BigInteger[][] dp = new BigInteger[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][1] = BigInteger.ONE;
        }
        for (int i = 0; i <= n; i++) {
            dp[1][i] = BigInteger.ONE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != 1 && j != 1) {
                    dp[i][j] = dp[i - 1][j].add(dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int i = 1800;
        int j = 1800;
        cache = new BigInteger[i + 1][j + 1];
        System.out.println(total(i, j));
        System.out.println(totalIterative(i, j));
    }
}
