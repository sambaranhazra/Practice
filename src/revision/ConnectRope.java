package revision;

import java.util.PriorityQueue;

public class ConnectRope {
    static int minCost(int[] arr) {
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            pq.add(arr[i]);
        }
        while (pq.size() > 1) {
            int lowest = pq.poll();
            int secondLowest = pq.poll();
            pq.add(lowest + secondLowest);
            total += (lowest + secondLowest);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] ropes = new int[]{1, 2, 3, 4, 5};
        System.out.println(minCost(ropes));
    }
}
