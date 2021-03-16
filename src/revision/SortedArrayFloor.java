package revision;

public class SortedArrayFloor {
    static int floor(int[] arr, int target) {
        int value = Integer.MIN_VALUE;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                value = Math.max(value, arr[mid]);
            }
            if (arr[mid] == target)
                break;
            if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return value;
    }

    static int ceil(int[] arr, int target) {
        int value = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                value = Math.min(value, arr[mid]);
            }
            if (arr[mid] == target)
                break;
            if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return value;
    }

    static char nextLetter(char[] arr, char c) {
        int low = 0, high = arr.length - 1;
        int value = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > c) {
                value = Math.min(value, arr[mid]);
                high = mid - 1;
            } else if (arr[mid] < c) {
                low = mid + 1;
            } else {
                if (mid < arr.length - 1) {
                    return arr[mid + 1];
                } else {
                    return Character.MAX_VALUE;
                }
            }
        }
        return (char) value;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 6, 7, 8, 9};
        System.out.println(floor(arr, 10));
        System.out.println(floor(arr, 1));
        System.out.println(floor(arr, 5));
        System.out.println(ceil(arr, 5));
        char[] chArray = new char[]{'a', 'b', 'c', 'e', 'g', 'm', 'x'};
        System.out.println(nextLetter(chArray, 'g'));
        System.out.println(nextLetter(chArray, 'x'));
    }
}
