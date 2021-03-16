package revision;

public class SortedAndRotated {
    static int minIndex(int[] nums) {
        int length = nums.length;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[(mid + 1) % length] && nums[mid] > nums[(mid + length - 1) % length])
                return (mid + 1) % length;
            else if (nums[mid] > nums[0])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    static int maxIndexReversed(int[] nums) {
        int length = nums.length;
        int low = 0, high = length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[(mid + 1) % length] && nums[mid] < nums[(mid + length - 1) % length])
                return (mid + 1) % length;
            else if (nums[mid] < nums[0])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, -300, 1, 2, 3, 4, 5};
        System.out.println(minIndex(arr));
        int[] reverse = new int[]{2, 1, 0, -1, 7, 6, 5, 4, 3};
        System.out.println(maxIndexReversed(reverse));
    }
}
