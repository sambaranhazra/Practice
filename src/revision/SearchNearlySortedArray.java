package revision;

public class SearchNearlySortedArray {
    static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = mid - 1;
            int next = mid + 1;
            if (target == arr[mid])
                return mid;
            if (prev >= 0 && target == arr[prev])
                return prev;
            if (next <= arr.length - 1 && target == arr[next])
                return next;
            if (arr[mid] > target)
                high = mid - 2;
            else
                low = mid + 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 7, 6, 8, 10, 9,};
        System.out.println(search(arr, 10));
        System.out.println(search(arr, 6));
        System.out.println(search(arr, 7));
        System.out.println(search(arr, 11));
    }
}
