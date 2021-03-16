package revision;

import java.util.HashMap;
import java.util.Map;

public class AnagramOccurrences {
    static int count(String text, String pattern) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            putIfAbsent(pMap, c);
        }

        int count = 0;
        int i = 0, j = 0;
        int window = pattern.length();
        while (j < text.length()) {
            char c = text.charAt(j);
            putIfAbsent(tMap, c);
            if (j - i + 1 == window) {
                if (pMap.equals(tMap)) {
                    count++;
                }
                removeIfPresent(tMap, text.charAt(i));
                i++;
            }
            j++;
        }
        return count;
    }

    private static void putIfAbsent(Map<Character, Integer> p, char c) {
        if (p.containsKey(c)) {
            p.put(c, p.get(c) + 1);
        } else {
            p.put(c, 1);
        }
    }

    private static void removeIfPresent(Map<Character, Integer> p, char c) {
        if (p.containsKey(c)) {
            if (p.get(c) > 1) {
                p.put(c, p.get(c) - 1);
            } else {
                p.remove(c);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(count("helleo", "le"));
        System.out.println(count("hellelo", "le"));
    }
}
