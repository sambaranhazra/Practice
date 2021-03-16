package revision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    static int length(String s) {
        int i = 0, j = 0;
        HashMap<Character, Integer> store = new HashMap<>();
        int maxSize = 0;
        while (j < s.length()) {
            add(store, s.charAt(j));
            if (store.size() == j - i + 1) {
                maxSize = Math.max(maxSize, j - i + 1);

            } else if (store.size() < j - i + 1) {
                while (store.size() < j - i + 1) {
                    remove(store, s.charAt(i));
                    i++;
                }
                if (store.size() == j - i + 1) {
                    maxSize = Math.max(maxSize, j - i + 1);
                }
            }
            j++;
        }
        return maxSize;
    }

    private static void remove(HashMap<Character, Integer> store, char c) {
        if (store.get(c) > 1)
            store.put(c, store.get(c) - 1);
        else
            store.remove(c);
    }

    private static void add(HashMap<Character, Integer> store, char c) {
        if (store.containsKey(c))
            store.put(c, store.get(c) + 1);
        else
            store.put(c, 1);
    }

    public static void main(String[] args) {
        System.out.println(length("abccdefghhhhhh"));
    }
}
