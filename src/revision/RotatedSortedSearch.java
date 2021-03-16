package revision;

class RotatedSortedSearch {
    static int minIndex(int[] arr) {
        int low = 0, len = arr.length, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int left = (mid + len - 1) % len;
            int right = (mid + 1) % len;
            if (arr[mid] < arr[left] && arr[mid] < arr[right])
                return (mid + 1) % len;
            if (arr[mid] < arr[0])
                low = mid + 1;
            else if (arr[mid] > arr[0])
                high = mid - 1;
        }
        return -1;
    }

    static int search(int[] arr, int key) {
        int index = minIndex(arr);
        if (index >= 0) {
            int result = binarySearch(arr, 0, index, key);
            return result == -1 ? binarySearch(arr, index, arr.length - 1, key) : result;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 6, 5, 4, 3, 2, 1,};
        System.out.println(search(arr, 50));
        System.out.println(search(arr, 1));
    }
}
