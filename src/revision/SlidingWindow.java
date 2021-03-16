package revision;

public class SlidingWindow {
    static int maxSum(int[] arr, int window) {
        int i = 0, j = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 == window) {
                maxSum = Integer.max(maxSum, sum);
                sum = sum - arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 1, 1, 2, 3, 4, 5, 6, 1, 1, 2, 3, 4, 5, 6, 1, 1, 2, 3, 4, 5, 6, 1, 1, 2, 3, 4, 5, 6, 1, 1, 2, 3, 4, 5, 6, 1};
        System.out.println(maxSum(arr, 3));
        System.out.println(maxSum(arr, 4));
    }
}
