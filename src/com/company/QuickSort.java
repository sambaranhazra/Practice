package com.company;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, -1};
        qSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void qSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int j = partition(arr, low, high);
        sort(arr, low, j - 1);
        sort(arr, j + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low, j = high + 1;
        int pivot = arr[low];
        while (true) {
            while (less(arr[++i], pivot)) if (i == high) break;
            while (less(pivot, arr[--j])) if (low == j) break;
            if (i >= j) break;
            exch(arr, i, j);
        }
        exch(arr, low, j);
        return j;
    }

    private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
