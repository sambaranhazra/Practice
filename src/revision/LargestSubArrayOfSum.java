package revision;

public class LargestSubArrayOfSum {
    static int length(int[] arr, int sum) {
        int i = 0, j = 0;
        int maxSize = Integer.MIN_VALUE;
        int s = 0;
        while (j < arr.length) {
            s += arr[j];
            if (s == sum) {
                maxSize = Integer.max(maxSize, j - i + 1);
            }
            if (s > sum) {
                while (s > sum) {
                    s = s - arr[i];
                    i++;
                }
                if (s == sum) {
                    maxSize = Integer.max(maxSize, j - i + 1);
                }
            }
            j++;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        System.out.println(length(new int[]{4, 1, 1, 1, 2, 3, 5}, 5));
        System.out.println(length(new int[]{4, 1, 1, 1, 2, 3, 5}, 4));
    }
}
