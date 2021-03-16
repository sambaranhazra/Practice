package com.company;

public class BinarySearchRecursive {
    static int search(int[] arr, int i, int j, int element) {
        if (j >= i && i < arr.length - 1) {
            int mid = i + (j - i) / 2;

            if (arr[mid] == element) return mid;
            if (arr[mid] > element)
                return search(arr, i, mid - 1, element);
            else
                return search(arr, mid + 1, j, element);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 50, 60};
        int element = 3;
        System.out.println(search(arr, 0, arr.length, element));
    }
}
