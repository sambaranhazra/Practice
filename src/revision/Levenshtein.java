package revision;

public class Levenshtein {
    static int[][] cache;

    static int distance(String a, String b, int la, int lb) {
        if (la == 0)
            return lb;
        if (lb == 0)
            return la;
        if (cache[la][lb] != 0) return cache[la][lb];
        if (a.charAt(la - 1) == b.charAt(lb - 1)) {
            return cache[la][lb] = distance(a, b, la - 1, lb - 1);
        } else {
            return cache[la][lb] = 1 + Math.min(distance(a, b, la - 1, lb - 1), Math.min(distance(a, b, la, lb - 1), distance(a, b, la - 1, lb)));
        }
    }

    static int distanceIterative(String a, String b) {
        int la = a.length();
        int lb = b.length();
        int[][] dp = new int[la + 1][lb + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        return dp[la][lb];
    }

    public static void main(String[] args) {
        String a = "fatten";
        String b = "fatten";
        cache = new int[a.length() + 1][b.length() + 1];
        //  System.out.println(distance(a, b, a.length(), b.length()));
        System.out.println(distanceIterative(a, b));
    }
}
