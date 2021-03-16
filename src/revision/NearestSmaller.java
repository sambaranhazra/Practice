package revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestSmaller {
    static List<Integer> toRight(int[] arr) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> sck = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (sck.isEmpty()) {
                result.add(-1);
            } else {
                if (sck.peek() < arr[i]) {
                    result.add(sck.peek());
                } else {
                    while (!sck.isEmpty() && sck.peek() > arr[i]) {
                        sck.pop();
                    }
                    if (sck.isEmpty())
                        result.add(-1);
                    else
                        result.add(sck.peek());
                }
            }
            sck.push(arr[i]);
        }
        Collections.reverse(result);
        return result;
    }

    static List<Integer> toLeft(int[] arr) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> sck = new Stack<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            if (sck.isEmpty()) {
                result.add(-1);
            } else {
                if (sck.peek() < arr[i]) {
                    result.add(sck.peek());
                } else {
                    while (!sck.isEmpty() && sck.peek() > arr[i]) {
                        sck.pop();
                    }
                    if (sck.isEmpty())
                        result.add(-1);
                    else
                        result.add(sck.peek());
                }
            }
            sck.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 10, 8};
        System.out.println(toRight(arr));
        System.out.println(toLeft(arr));
    }
}
