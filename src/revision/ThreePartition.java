package revision;

import java.util.Arrays;
import java.util.HashMap;

public class ThreePartition {
    static HashMap<String, Boolean> cache = new HashMap<>();

    static boolean canPartition(int[] arr, int n, int a, int b, int c) {
        String key = n + "|" + a + "|" + b + "|" + c;
        if (a == 0 && b == 0 && c == 0) {
            cache.put(key, true);
            return true;
        }
        if (n == 0) {
            cache.put(key, false);
            return false;
        }
        if (cache.containsKey(key)) return cache.get(key);
        boolean A = false;
        if (a >= arr[n - 1]) {
            A = canPartition(arr, n - 1, a - arr[n - 1], b, c);
        }
        boolean B = false;
        if (!A && b >= arr[n - 1]) {
            B = canPartition(arr, n - 1, a, b - arr[n - 1], c);
        }
        boolean C = false;
        if ((!A && !B) && c >= arr[n - 1]) {
            C = canPartition(arr, n - 1, a, b, c - arr[n - 1]);
        }
        cache.put(key, A || B || C);
        return cache.get(key);
    }

    static boolean partition(int[] arr) {
        int total = Arrays.stream(arr).sum();
        if (total % 3 != 0) return false;
        return canPartition(arr, arr.length, total / 3, total / 3, total / 3);
    }

    public static void main(String[] args) {
        System.out.println(partition(new int[]{3, 2, 1, 1, 2}));
    }
}
