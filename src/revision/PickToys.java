package revision;

import java.util.HashMap;
import java.util.Map;

public class PickToys {
    static int max(char[] toys, int type) {
        int i = 0, j = 0;
        Map<Character, Integer> count = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        while (j < toys.length) {
            putToyInMap(count, toys[j]);
            if (count.size() == type) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            if (count.size() > type) {
                while (count.size() > type) {
                    removeToyFromFirst(count, toys[i]);
                    i++;
                }
                if (count.size() == type) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
            j++;
        }
        return maxLength;
    }

    private static void removeToyFromFirst(Map<Character, Integer> count, char toy) {
        if (count.get(toy) > 1)
            count.put(toy, count.get(toy) - 1);
        else
            count.remove(toy);
    }

    private static void putToyInMap(Map<Character, Integer> count, char toy) {
        if (count.containsKey(toy))
            count.put(toy, count.get(toy) + 1);
        else
            count.put(toy, 1);
    }

    public static void main(String[] args) {
        char[] toys = "abacca".toCharArray();
        System.out.println(max(toys, 2));
    }
}
