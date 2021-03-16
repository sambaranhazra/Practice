package com.company;

public class PalindromePartition {
    static int[][] cache;

    static int solve(String s, int i, int j) {
        if (i >= j) return 0;
        if (isPalindrome(s, i, j)) return 0;
        if (cache[i][j] != 0) return cache[i][j];
        int minPartition = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(s, i, k) + solve(s, k + 1, j) + 1;
            if (temp < minPartition)
                minPartition = temp;
        }
        return cache[i][j] = minPartition;
        //return minPartition;
    }

    static boolean isPalindrome(String s, int i, int j) {
        if (i >= j) return true;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "hellothereisagoodboy";
        cache = new int[s.length() + 1][s.length() + 1];
        System.out.println(solve(s, 0, s.length() - 1));
    }
}
