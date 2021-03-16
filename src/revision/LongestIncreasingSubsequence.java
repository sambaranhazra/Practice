package revision;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int length(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j] && res[i] <= res[j])
                    res[i] = res[j] + 1;
            }
        }
        return Arrays.stream(res).max().orElse(1);
    }

    public static void main(String[] args) {
        System.out.println(length(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
