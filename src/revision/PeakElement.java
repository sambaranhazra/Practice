package revision;

public class PeakElement {
    static int peakIndex(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int left = mid - 1;
            int right = mid + 1;
            boolean greaterThanLeft = true;
            boolean greaterThanRight = true;
            if (left >= 0) {
                greaterThanLeft = arr[mid] > arr[left];
            }
            if (right <= arr.length - 1) {
                greaterThanRight = arr[mid] > arr[right];
            }
            if (greaterThanLeft && greaterThanRight)
                return mid;
            else if (!greaterThanLeft)
                high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] elements = new int[]{6, 2, 3, 4, 1};
        System.out.println(peakIndex(elements));
    }
}
