package com.company;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{1, 2, 1, 3, 5, -1})));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length <= 1)
            return arr;
        else {
            int[] left = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
            int[] right = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
            return merge(left, right);
        }
    }

    private static int[] merge(int[] left, int[] right) {
        int[] merge = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                merge[k] = left[i];
                i++;
            } else {
                merge[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            merge[k++] = left[i++];
        }
        while (j < right.length) {
            merge[k++] = right[j++];
        }
        return merge;
    }
}

