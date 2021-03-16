package revision;

public class MaxProfitStockPurchase {
    static int[][] cache;

    static int maxProfit(int[] prices, int k, int n) {
        if (k == 0 || n == 0)
            return 0;
        if (cache[n][k] != 0) return cache[n][k];
        int profit = 0;
        for (int i = 0; i < n - 1; i++) {
            profit = Math.max(profit, prices[n - 1] - prices[i] + maxProfit(prices, k - 1, i));
        }
        profit = Math.max(profit, maxProfit(prices, k, n - 1));
        return cache[n][k] = profit;
    }


    public static void main(String[] args) {
        int[] prices = new int[]{10, 20, 5, 90, 123, 54, 32, 1};
        int k = 1;
        cache = new int[prices.length + 1][k + 1];
        System.out.println(maxProfit(prices, k, prices.length));
    }
}
