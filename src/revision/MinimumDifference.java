package revision;

public class MinimumDifference {
    static int minDifference(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = arr[mid];
            if (midVal == key)
                return 0;
            else if (midVal > key) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        int answer = Integer.MAX_VALUE;

        if (high > 0)
            answer = Math.min(answer, Math.abs(key - arr[high]));
        if (low < arr.length)
            answer = Math.min(answer, Math.abs(key - arr[low]));

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 10, 15};
        System.out.println(minDifference(arr, 4));
        System.out.println(minDifference(arr, 6));
    }
}
