package com.company;

public class MaxNonDecreasingSubsequence {
    public static int getElementCount(int[] arr) {
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) continue;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getElementCount(new int[]{10, 10, 22, 9, 33, 21, 50, 41, 60}));
    }
}
