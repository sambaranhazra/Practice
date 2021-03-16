package revision;

import java.util.Arrays;

public class MinimumSubsetSumDifference {
    static Boolean[][] cache;

    static boolean subsetSum(int sum, int[] arr, int n) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        if (cache[n][sum] != null) return cache[n][sum];
        if (sum < arr[n - 1])
            return cache[n][sum] = subsetSum(sum, arr, n - 1);
        else
            return cache[n][sum] = subsetSum(sum, arr, n - 1) || subsetSum(sum - arr[n - 1], arr, n - 1);
    }

    static int minSubsetSumDifference(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int d = 0;
        for (int i = sum / 2; i > 0; i--) {
            cache = new Boolean[arr.length + 1][i + 1];
            if (subsetSum(i, arr, arr.length)) {
                d = i;
                break;
            }
        }

        return sum - 2 * d;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{31,26,33,21,40};
        System.out.println(minSubsetSumDifference(arr));
    }
}
