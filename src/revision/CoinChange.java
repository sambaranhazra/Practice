package revision;

public class CoinChange {
    static int[][] cache;

    static int total(int[] coins, int amount, int n) {
        if (amount == 0) return 1;
        if (n == 0) return 0;
        if (cache[n][amount] != 0) return cache[n][amount];
        if (coins[n - 1] > amount) {
            return cache[n][amount] = total(coins, amount, n - 1);
        } else {
            return cache[n][amount] = total(coins, amount, n - 1) + total(coins, amount - coins[n - 1], n);
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int amount = 120;
        cache = new int[coins.length + 1][amount + 1];
        System.out.println(total(coins, amount, coins.length));
    }
}
