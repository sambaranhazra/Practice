package com.company;

import java.util.HashMap;

public class AnagramMaker {
    static int makeAnagram(String a, String b) {
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char key = a.charAt(i);
            if (mapA.containsKey(key)) {
                mapA.put(key, mapA.get(key) + 1);
            } else {
                mapA.put(key, 1);
            }
        }
        for (int i = 0; i < b.length(); i++) {
            char key = b.charAt(i);
            if (mapB.containsKey(key)) {
                mapB.put(key, mapB.get(key) + 1);
            } else {
                mapB.put(key, 1);
            }
        }
        int count = 0;
        for (Character c : mapA.keySet()) {
            if (!mapB.containsKey(c)) count += mapA.get(c);
            else if (mapA.get(c) > mapB.get(c)) count += mapA.get(c) - mapB.get(c);
        }
        for (Character c : mapB.keySet()) {
            if (!mapA.containsKey(c)) count += mapB.get(c);
            else if (mapB.get(c) > mapA.get(c)) count += mapB.get(c) - mapA.get(c);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(makeAnagram("fsqoiaidfaukvngpsugszsnseskicpejjvytviya", "ksmfgsxamduovigbasjchnoskolfwjhgetnmnkmcphqmpwnrrwtymjtwxget"));
        System.out.println(makeAnagram("cde", "abc"));
    }
}
