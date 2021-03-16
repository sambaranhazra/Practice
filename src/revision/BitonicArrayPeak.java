package revision;

public class BitonicArrayPeak {

    static int peakElement(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && mid < arr.length - 1) {
                int left = mid - 1;
                int right = mid + 1;
                if (arr[mid] > arr[left] && arr[mid] > arr[right])
                    return arr[mid];
                else if (arr[mid] < arr[left]) {
                    high = mid - 1;
                } else if (arr[mid] < arr[right]) {
                    low = mid + 1;
                }
            } else low++;
        }
        return 0;
    }

    static int search(int[] arr, int target) {
        int peakIndex = findPeak(arr);
        int left = binarySearch(arr, 0, peakIndex, target);
        int right = binaryReverse(arr, peakIndex + 1, arr.length - 1, target);
        return left != -1 ? left : right;
    }

    private static int binaryReverse(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid])
                return mid;
            else if (target > arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid])
                return mid;
            else if (target < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private static int findPeak(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && mid < arr.length - 1) {
                int left = mid - 1;
                int right = mid + 1;
                if (arr[mid] > arr[left] && arr[mid] > arr[right])
                    return mid;
                else if (arr[mid] < arr[left])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else
                throw new RuntimeException("Not a bitonic array");
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] bitonic = new int[]{1, 3, 8, 12, 6, 5, 1};
        System.out.println(peakElement(bitonic));
        System.out.println(search(bitonic, 5));
    }
}
