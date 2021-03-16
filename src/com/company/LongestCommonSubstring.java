package com.company;

public class LongestCommonSubstring {
    static int lengthSubString(String a, String b, int la, int lb, int res) {
        if (la == 0 || lb == 0) return res;
        if (a.charAt(la - 1) == b.charAt(lb - 1)) {
            res = lengthSubString(a, b, la - 1, lb - 1, res + 1);
        }
        return Math.max(res, Math.max(lengthSubString(a, b, la - 1, lb, 0), lengthSubString(a, b, la, lb - 1, 0)));
    }

    public static void main(String[] args) {

        String abc = "abcde";
        String abcd = "abcde";
        int x = lengthSubString(abc, abcd, abc.length(), abcd.length(), 0);
        System.out.println(x);
    }
}
