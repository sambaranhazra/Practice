package revision;

public class Knapsack {
    static int[][] cache;

    static int maxProfit(int[] weight, int[] value, int totalWeight, int count) {
        if (totalWeight == 0 || count == 0) return 0;
        if (cache[totalWeight][count] != 0) return cache[totalWeight][count];
        if (weight[count - 1] > totalWeight)
            return cache[totalWeight][count] = maxProfit(weight, value, totalWeight, count - 1);
        else {
            return cache[totalWeight][count] = Math.max(maxProfit(weight, value, totalWeight, count - 1),
                    maxProfit(weight, value, totalWeight - weight[count - 1], count - 1)
                            + value[count - 1]);
        }
    }

    public static void main(String[] args) {
        int[] weight = {1, 2, 3, 4, 5, 9, 10, 3, 4};
        int[] value = {10, 15, 40, 60, 65, 43, 11, 34, 43};
        int totalWeight = 70;
        int count = weight.length;
        cache = new int[totalWeight + 1][count + 1];

        System.out.println(maxProfit(weight, value, totalWeight, count));
        //System.out.println(knapsackIterative(weight, value, totalWeight, count));
    }
}
