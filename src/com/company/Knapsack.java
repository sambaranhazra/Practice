package com.company;

public class Knapsack {
    private static int[][] cache;

    public static int knapsack(int[] weight, int[] value, int totalWeight, int count) {
        if (totalWeight == 0 || count == 0) return 0;
        if (cache[totalWeight][count] != -1) return cache[totalWeight][count];
        if (weight[count - 1] <= totalWeight) {
            cache[totalWeight][count] = Math.max(knapsack(weight, value, totalWeight - weight[count - 1], count - 1) + value[count - 1],
                    knapsack(weight, value, totalWeight, count - 1));
        } else
            cache[totalWeight][count] = knapsack(weight, value, totalWeight, count - 1);
        return cache[totalWeight][count];
    }

    public static int knapsackIterative(int[] weight, int[] value, int totalWeight, int count) {
        int[][] t = new int[count + 1][totalWeight + 1];
        for (int i = 0; i <= count; i++) {
            for (int j = 0; j <= totalWeight; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= totalWeight; j++) {
                if (weight[i - 1] <= j) {
                    t[i][j] = Math.max(value[i - 1] + t[i - 1][j - weight[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[count][totalWeight];
    }

    public static void main(String[] args) {
        int[] weight = {1, 2, 3};
        int[] value = {10, 15, 40};
        int totalWeight = 6;
        int count = weight.length;
        cache = new int[totalWeight + 1][count + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        System.out.println(knapsack(weight, value, totalWeight, count));
        System.out.println(knapsackIterative(weight, value, totalWeight, count));
    }
}
