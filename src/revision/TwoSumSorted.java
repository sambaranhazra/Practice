package revision;

public class TwoSumSorted {
    static boolean hasSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int total = nums[i] + nums[j];
            if (total == target)
                return true;
            else if (total > target)
                j--;
            else
                i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 8, 8};
        System.out.println(hasSum(nums, 16));
    }
}
