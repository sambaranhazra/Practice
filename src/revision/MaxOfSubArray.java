package revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxOfSubArray {
    static List<Integer> max(int[] arr, int window) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, j = 0;
        while (j < arr.length) {
            queue.add(arr[j]);
            if (j - i + 1 == window) {
                if (!queue.isEmpty()) {
                    result.add(queue.peek());
                    if (queue.peek().equals(arr[i])) {
                        queue.poll();
                    }
                }
                i++;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(max(new int[]{1, 2, 3, -2, 10, 4, 5, 8}, 2));
        System.out.println(max(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
