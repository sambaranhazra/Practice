package com.company;

public class Abbreviate {
    static boolean abbreviateInternally(String a, String b) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < a.length() && j < b.length()) {
            char c = a.charAt(i);
            String current = "" + c;
            String d = "" + b.charAt(j);
            if (current.equals(d) || current.toUpperCase().equals(d)) {
                sb.append(d);
                j++;
            } else {
                if (current.equals(current.toUpperCase())) {
                    System.out.println(sb.toString());
                    System.out.println(current);
                    System.out.println(d);
                    return false;
                }
            }
            i++;
        }
        String remaining = a.substring(i);
        if (!remaining.equals(remaining.toLowerCase())) return false;
        return j == b.length();
    }

    public static void main(String[] args) {
        System.out.println(abbreviateInternally("MCLGDNAYZOVXJqJDAYrFHrBYZOUDBGEFfBTBZpNEZLURWEcDEBJQWIITUTNEteBHYYKOEGROMXmLEudSEWlUEFFTvINEHWNFObNOMWTNJMIyBEXTWBWOAKHNZKeEdCFuUSfAPXXZUZTDCVYmDFTSSGECgOHOQHSPEBUUWTspaviedpoeh", "MCLGDNAYZOVXJJDAYFHBYZOUDBGEFBTBZNEZLURWEDEBJQWIITUTNEBHYYKOEGROMXLESEWUEFFTINEHWNFONOMWTNJMIBEXTWBWOAKHNZKECFUSAPXXZUZTDCVYDFTSSGECOHOQHSPEBUUWT"));
    }
}
