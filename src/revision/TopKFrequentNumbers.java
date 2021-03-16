package revision;


import kotlin.Pair;

import java.util.*;

public class TopKFrequentNumbers {
    static List<Integer> topKFrequent(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Pair<Integer, Integer>> numsWithFrequency = new HashMap<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            insertIntoHashMap(numsWithFrequency, arr[i]);
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair<Integer, Integer>::getSecond));
        for (Pair<Integer, Integer> pair : numsWithFrequency.values()) {
            pq.add(pair);
            if (pq.size() > k)
                pq.poll();
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll().getFirst());
        }
        return result;
    }

    private static void insertIntoHashMap(HashMap<Integer, Pair<Integer, Integer>> numsWithFrequency, int i) {
        if (numsWithFrequency.containsKey(i))
            numsWithFrequency.put(i, new Pair<>(i, numsWithFrequency.get(i).getSecond() + 1));
        else
            numsWithFrequency.put(i, new Pair<>(i, 1));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 2, 1, 5, 6, 4, 2, 3, 3, 3, 8, 8, 8, 8, 8, 8, 9,};
        System.out.println(topKFrequent(arr, 3));
        System.out.println(topKFrequent(arr, 4));
    }
}


