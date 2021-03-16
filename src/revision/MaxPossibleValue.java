package revision;

import java.util.HashMap;

public class MaxPossibleValue {
    static HashMap<String, Integer> cache = new HashMap<>();

    static int value(int[] arr, int start, int end) {
        String key = start + "|" + end;
        if (start == end) {
            cache.put(key, arr[start]);
            return cache.get(key);
        }
        if (cache.containsKey(key)) return cache.get(key);
        int allMax = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            int currMax = Math.max(value(arr, start, i) + value(arr, i + 1, end), Math.max(value(arr, start, i) * value(arr, i + 1, end), value(arr, start, i) - value(arr, i + 1, end)));
            if (currMax > allMax)
                allMax = currMax;
        }
        cache.put(key, allMax);
        return allMax;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -1, -1};
        System.out.println(value(arr, 0, arr.length - 1));
    }
}
