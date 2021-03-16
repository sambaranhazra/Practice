package revision;

public class KthSymbol {
    static boolean symbol(int n, int k) {
        if (n == 1 && k == 1) return false;
        int len = (int) Math.pow(2, n - 1);
        int mid = len / 2;
        if (k <= mid)
            return symbol(n - 1, k);
        else
            return !symbol(n - 1, k - mid);
    }

    public static void main(String[] args) {
        System.out.println(symbol(3, 2));
    }
}
