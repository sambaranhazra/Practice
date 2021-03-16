package com.company;

public class LongestPalindromeSubstring {
    static Pair[][] cache;

    static Pair subStringLength(String a, int i, int j) {
        if (i > j) return new Pair(-1, 0);
        if (i == j) return new Pair(i, 1);
        if (isPalindrome(a, i, j))
            return new Pair(i, j - i + 1);
        if (cache[i][j] != null) return cache[i][j];
        Pair maxSize = new Pair(-1, 0);
        for (int k = i; k <= j - 1; k++) {
            Pair first = subStringLength(a, i, k);
            Pair second = subStringLength(a, k + 1, j);
            Pair temp = null;
            if (first.length > second.length)
                temp = first;
            else
                temp = second;
            if (temp.length > maxSize.length)
                maxSize = temp;
        }
        cache[i][j] = maxSize;
        return maxSize;
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

    static public String longestPalindrome(String s) {
        cache = new Pair[s.length() + 1][s.length() + 1];
        Pair x = subStringLength(s, 0, s.length() - 1);
        return s.substring(x.start, x.start + x.length);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"));
    }

    static class Pair {
        int start;
        int length;

        public Pair(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }
}

