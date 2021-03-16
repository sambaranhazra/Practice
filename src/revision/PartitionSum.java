package revision;

import java.util.Arrays;

public class PartitionSum {
    static boolean canPartition(int[] array, int val, int n) {
        if (val == 0) return true;
        if (n == 0) return false;
        if (array[n - 1] > val) return canPartition(array, val, n - 1);
        else {
            return canPartition(array, val, n - 1) || canPartition(array, val - array[n - 1], n - 1);
        }
    }

    static boolean partitionSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) return false;
        else
            return canPartition(arr, sum / 2, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 1, 2, 2, 1, 1, 1, 2};
        System.out.println(partitionSum(arr));
    }
}
