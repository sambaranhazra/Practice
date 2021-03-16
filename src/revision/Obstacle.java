package revision;

public class Obstacle {
    static int[][] cache;

    static public int uniquePathsWithObstacles(int[][] obstacle) {
        int m = obstacle.length;
        if (m == 0) return 0;
        int n = obstacle[0].length;
        cache = new int[m + 1][n + 1];
        cache[1][1] = Math.abs(obstacle[0][0] - 1);
        for (int i = 2; i <= m; i++) {
            if (obstacle[i - 1][0] == 0) cache[i][1] = cache[i - 1][1];
            else cache[i][1] = 0;
        }
        for (int i = 2; i <= n; i++) {
            if (obstacle[0][i - 1] == 0) cache[1][i] = cache[1][i - 1];
            else cache[1][i] = 0;
        }
        return ways(obstacle, m, n);
    }

    private static int ways(int[][] obstacle, int m, int n) {
        if (obstacle[m - 1][n - 1] != 0 || obstacle[0][0] != 0) return 0;
        if (n == 1 || m == 1) return cache[m][n];
        if (cache[m][n] != 0) return cache[m][n];
        int topWays = obstacle[m - 2][n - 1] == 0 ? ways(obstacle, m - 1, n) : 0;
        int leftWays = obstacle[m - 1][n - 2] == 0 ? ways(obstacle, m, n - 1) : 0;
        return cache[m][n] = topWays + leftWays;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int x = uniquePathsWithObstacles(arr);
        System.out.println(x);
    }
}
