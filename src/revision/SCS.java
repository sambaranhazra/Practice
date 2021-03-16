package revision;

public class SCS {

    static int[][] cache;

    static int length(String a, String b) {
        cache = new int[a.length() + 1][b.length() + 1];
        int lcs = lcsLength(a, b, a.length(), b.length());
        return a.length() + b.length() - lcs;
    }

    static String getSuperSequence(String a, String b) {
        cache = new int[a.length() + 1][b.length() + 1];
        lcsLength(a, b, a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int i = cache.length - 1;
        int j = cache[0].length - 1;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (cache[i - 1][j] > cache[i][j - 1]) {
                    sb.append(a.charAt(i - 1));
                    i--;
                } else {
                    sb.append(b.charAt(j - 1));
                    j--;
                }
            }
        }
        while (i > 0) {
            sb.append(a.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(b.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }

    static String getSubSequence(String a, String b) {
        cache = new int[a.length() + 1][b.length() + 1];
        lcsLength(a, b, a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int i = cache.length - 1;
        int j = cache[0].length - 1;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (cache[i - 1][j] > cache[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return sb.reverse().toString();
    }

    private static int lcsLength(String a, String b, int la, int lb) {
        if (la == 0 || lb == 0) return 0;
        if (cache[la][lb] != 0) return cache[la][lb];
        if (a.charAt(la - 1) == b.charAt(lb - 1)) {
            return cache[la][lb] = 1 + lcsLength(a, b, la - 1, lb - 1);
        } else {
            int aLCS = lcsLength(a, b, la - 1, lb);
            int bLCS = lcsLength(a, b, la, lb - 1);
            return cache[la][lb] = Math.max(aLCS, bLCS);
        }
    }

    public static void main(String[] args) {
        System.out.println(getSuperSequence("abdfsfdsfdsfdsfsdffsferfreferfrefrefrefrefcxvxcvxcvdcvervewvdsv", "abdsuvbdfbvdfvnndkvnfkdvndfnvkfdvnfdviernoenevn"));
        System.out.println(getSubSequence("abdfsfdsfdsfdsfsdffsferfreferfrefrefrefrefcxvxcvxcvdcvervewvdsv", "abdsuvbdfbvdfvnndkvnfkdvndfnvkfdvnfdviernoenevn"));
        System.out.println(getSuperSequence("abcdefabc", "xyzabc"));
        System.out.println(getSubSequence("abcdefabc", "xyzabcabc"));
    }
}
