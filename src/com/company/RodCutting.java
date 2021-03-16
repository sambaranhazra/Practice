package com.company;

public class RodCutting {
    static int[][] cache;

    static int maximizeProfit(int[] cut, int[] value, int totalLength, int n) {
        if (totalLength == 0 || n == 0) return 0;
        if (cache[n][totalLength] != 0) return cache[n][totalLength];
        if (cut[n - 1] > totalLength)
            cache[n][totalLength] = maximizeProfit(cut, value, totalLength, n - 1);
        else
            cache[n][totalLength] = Math.max(maximizeProfit(cut, value, totalLength, n - 1),
                    value[n - 1] + maximizeProfit(cut, value, totalLength - cut[n - 1], n));
        return cache[n][totalLength];
    }

    public static void main(String[] args) {
        int[] cut = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] value = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int totalLength = 8;
        cache = new int[cut.length + 1][totalLength + 1];
        System.out.println(maximizeProfit(cut, value, totalLength, cut.length));
    }
}
