package revision;

public class LCS {
    static int[][] cache;

    static int length(String a, String b, int la, int lb) {
        if (la == 0 || lb == 0) return 0;
        if (cache[la][lb] != 0) return cache[la][lb];
        if (a.charAt(la - 1) == b.charAt(lb - 1))
            return cache[la][lb] = 1 + length(a, b, la - 1, lb - 1);
        else
            return cache[la][lb] = Math.max(length(a, b, la - 1, lb), length(a, b, la, lb - 1));
    }

    public static void main(String[] args) {
        String a = "abcabcabcabcabcabcewdewdwedwewdewhifnkewfhnkwenfkewnfkwenfkewnkewnfnewfnewkfnewkfnewknkewnekwfnewknfewkn";
        String b = "abcabcabcabcabcabcwdewdewdewdwedweklenwlfnwlekfnlkewfnlewkfnlewfknwlekfnlewnfkewfnewfnewfnflkwflkwenfenewnlfewn";
        cache = new int[a.length() + 1][b.length() + 1];
        System.out.println(length(a, b, a.length(), b.length()));
    }
}
