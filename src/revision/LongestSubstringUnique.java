package revision;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringUnique {
    static int length(String s, int k) {
        int i = 0, j = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> counts = new HashMap<>();
        while (j < s.length()) {
            addToMap(counts, s.charAt(j));
            if (counts.size() == k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            if (counts.size() > k) {
                while (counts.size() > k) {
                    removeFromMap(counts, s.charAt(i));
                    i++;
                }
                if (counts.size() == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
            j++;
        }
        return maxLength;
    }

    private static void removeFromMap(Map<Character, Integer> counts, char key) {
        if (counts.get(key) == 1)
            counts.remove(key);
        else
            counts.put(key, counts.get(key) - 1);
    }

    private static void addToMap(Map<Character, Integer> counts, char key) {
        if (counts.containsKey(key))
            counts.put(key, counts.get(key) + 1);
        else
            counts.put(key, 1);
    }

    public static void main(String[] args) {
        System.out.println(length("aabacbebebe", 3));
        System.out.println(length("efabacbebebe", 4));
    }
}
