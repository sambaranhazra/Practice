package revision;

public class RotatedArray {
    static int findMinIndex(int[] arr) {
        int N = arr.length;

        int low = 0, high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid + N - 1) % N;
            int next = (mid + 1) % N;
            if (arr[mid] < arr[prev] && arr[mid] < arr[next])
                return mid;
            if (arr[mid] <= arr[high])
                high = mid - 1;
            else if (arr[low] <= arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    static int findMaxIndex(int[] arr) {
        int N = arr.length;
        int low = 0, high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid + N - 1) % N;
            int next = (mid + 1) % N;
            if (arr[mid] > arr[prev] && arr[mid] > arr[next])
                return mid;
            if (arr[low] <= arr[mid])
                low = mid + 1;
            else if (arr[mid] <= arr[high])
                high = mid - 1;
        }
        return -1;
    }

    static int noOfTimesRotatedLeft(int[] arr) {
        int len = arr.length;
        return (len - findMinIndex(arr)) % len;
    }

    static int noOfTimesRotatedRight(int[] arr) {
        int len = arr.length;
        return (findMaxIndex(arr) + 1) % len;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -300, -43, -40};
        System.out.println(noOfTimesRotatedLeft(arr));
        System.out.println(noOfTimesRotatedRight(arr));
    }
}
