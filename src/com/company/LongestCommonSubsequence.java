package com.company;

public class LongestCommonSubsequence {
    static int[][] cache;

    static int lcs(String a, String b, int la, int lb) {
        if (la == 0 || lb == 0) return 0;
        if (cache[la][lb] != 0) return cache[la][lb];
        if (a.charAt(la - 1) == b.charAt(lb - 1))
            cache[la][lb] = 1 + lcs(a, b, la - 1, lb - 1);
        else
            cache[la][lb] = Math.max(lcs(a, b, la - 1, lb), lcs(a, b, la, lb - 1));
        return cache[la][lb];
    }

    static int lcsIterative(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }


    static String printLcs(String a, String b) {
        lcs(a, b, a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int i = cache.length - 1;
        int j = cache[0].length - 1;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (cache[i][j - 1] > cache[i - 1][j])
                    j--;
                else
                    i--;
            }
        }
        return sb.reverse().toString();
    }

    static String printScs(String a, String b) {
        lcs(a, b, a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int i = cache.length - 1;
        int j = cache[0].length - 1;

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (cache[i][j - 1] > cache[i - 1][j]) {
                    sb.append(b.charAt(j - 1));
                    j--;
                } else {
                    sb.append(a.charAt(i - 1));
                    i--;
                }
            }
        }
        while (i > 0) {
            sb.append(a.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(b.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "dabcdef";
        String b = "eabdf";
        cache = new int[a.length() + 1][b.length() + 1];
        System.out.println(printLcs(a, b));
        System.out.println(printScs(a, b));
    }
}
