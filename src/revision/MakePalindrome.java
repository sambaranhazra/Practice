package revision;

public class MakePalindrome {
    static int[][] cache;

    static int lcs(String a, String b, int la, int lb) {
        if (la == 0 || lb == 0)
            return 0;
        if (cache[la][lb] != 0) return cache[la][lb];
        if (a.charAt(la - 1) == b.charAt(lb - 1))
            return cache[la][lb] = 1 + lcs(a, b, la - 1, lb - 1);
        else
            return cache[la][lb] = Math.max(lcs(a, b, la - 1, lb), lcs(a, b, la, lb - 1));
    }

    static int makePalindrome(String a) {
        String b = new StringBuilder(a).reverse().toString();
        cache = new int[a.length() + 1][b.length() + 1];
        return a.length() - lcs(a, b, a.length(), b.length());
    }

    public static void main(String[] args) {
        System.out.println(makePalindrome("bwewfregergdfrefrefrefeqwdqdwqdwwdassabab"));
        System.out.println(makePalindrome("xcbasabnabasabx"));
    }
}
