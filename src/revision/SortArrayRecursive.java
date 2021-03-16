package revision;

import java.util.Arrays;

public class SortArrayRecursive {
    static void sort(int[] arr, int n) {
        if (n > 1) {
            sort(arr, n - 1);
            for (int i = n - 1; i > 0; i--) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, -1, 5, -4, Integer.MAX_VALUE, Integer.MIN_VALUE};
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
