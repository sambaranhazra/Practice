package com.company;

public class MaxProductSubArray {
    static public int maxProduct(int[] arr) {
        if (arr.length == 0)
            return 0;
        int minProduct = arr[0];
        int maxProduct = arr[0];
        int sol = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp1 = Math.min(arr[i] * minProduct, arr[i] * maxProduct);
            int temp2 = Math.max(arr[i] * minProduct, arr[i] * maxProduct);
            minProduct = Math.min(temp1, arr[i]);
            maxProduct = Math.max(temp2, arr[i]);
            sol = Math.max(sol, maxProduct);
        }
        return sol;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2, 3, -4}));
    }
}
