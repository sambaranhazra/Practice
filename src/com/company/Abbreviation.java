package com.company;

/*

    You can perform the following operations on the string, : a

    Capitalize zero or more of a's lowercase letters.
    Delete all of the remaining lowercase letters in a.

    Given two strings, a and b , determine if it's possible to make a equal to b as described.
     If so, print YES on a new line. Otherwise, print NO.
 */
public class Abbreviation {
    public static String abbreviation(String a, String b) {
        int i = 0;
        int j = 0;
        int aLen = a.length();
        int bLen = b.length();
        while (i < aLen) {
            char c = a.charAt(i);
            boolean isLower = c >= 97 && c <= 122;
            if (j < bLen) {
                char d = b.charAt(j);
                c = isLower ? (char) (c - 32) : c;
                if (c == d) {
                    j++;
                } else if (!isLower) return "NO";
            } else {
                if (!isLower) return "NO";
            }
            i++;
        }
        if (j == bLen) return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(abbreviation("MCLGDNAYZOVXJqJDAYrFHrBYZOUDBGEFfBTBZpNEZLURWEcDEBJQWIITUTNEteBHYYKOEGROMXmLEudSEWlUEFFTvINEHWNFObNOMWTNJMIyBEXTWBWOAKHNZKeEdCFuUSfAPXXZUZTDCVYmDFTSSGECgOHOQHSPEBUUWTspaviedpoeh", "MCLGDNAYZOVXJJDAYFHBYZOUDBGEFBTBZNEZLURWEDEBJQWIITUTNEBHYYKOEGROMXLESEWUEFFTINEHWNFONOMWTNJMIBEXTWBWOAKHNZKECFUSAPXXZUZTDCVYDFTSSGECOHOQHSPEBUUWT"));
    }
}
