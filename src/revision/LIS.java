package revision;

import java.util.Arrays;

public class LIS {
    static int length(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, 1);
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && result[i] <= result[j])
                    result[i] = result[j] + 1;
            }
        }
        return Arrays.stream(result).max().orElse(1);
    }

    static public boolean increasingTriplet(int[] nums) {
        return length(nums) >= 3;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 7};
        System.out.println(length(array));
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
}
