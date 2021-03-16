package com.company;

public class BinarySearchIterative {
    static int search(int[] arr, int target) {
        int low = 0, high = arr.length;
        return binarySearch(arr, low, high, target);
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 3));
    }
}
