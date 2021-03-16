package revision;

import java.util.LinkedList;
import java.util.List;

public class FirstNegativeSliding {

    static void print(int[] arr, int window) {
        int i = 0, j = 0;
        List<Integer> negatives = new LinkedList<>();
        while (j < arr.length) {
            if (arr[j] < 0) {
                negatives.add(arr[j]);
            }
            if (j - i + 1 == window) {
                if (negatives.size() == 0)
                    System.out.print(0 + " ");
                else
                    System.out.print(negatives.get(0) + " ");
                if (negatives.size() != 0 && negatives.get(0) == arr[i])
                    negatives.remove(0);
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{12, -1, -7, 2, 3, -4, -5, -7, 1, 2, 3, 4, 5, 12, -1, -7, 2, 3, -4, -5, -7, 1, 2, 3, 4, 5, 12, -1, -7, 2, 3, -4, -5, -7, 1, 2, 3, 4, 5, 12, -1, -7, 2, 3, -4, -5, -7, 1, 2, 3, 4, 512, -1, -7, 2, 3, -4, -5, -7, 1, 2, 3, 4, 5};
        print(array, 3);
        System.out.println();
        print(array, 4);
    }
}
