package com.company;

public class LongestNonDecreasingSubsequence {

    static int length(int[] array, int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int max = 0;
        int j = n - 1;
        while (j > 0) {
            int b;
            if (array[j - 1] <= array[j]) {
                b = length(array, j) + 1;
            } else
                b = 1;
            max = Math.max(max, b);
            j--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 5};
        System.out.println(length(array, array.length));
    }
}
