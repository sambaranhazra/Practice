package revision;

public class BinarySearch {
    static int search(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == arr[mid])
                return mid;
            else if (key > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int key = 7;
        System.out.println(search(arr, 0, arr.length - 1, key));
        System.out.println(search(arr, 0, arr.length - 1, 5));
    }
}
