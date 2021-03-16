package com.company;

import java.util.Arrays;

public class Bribes {
    static void minimumBribes(int[] q) {
        boolean isChaos = false;
        for (int i = 0; i < q.length - 1; i++) {
            if (q[i] - i > 3) {
                isChaos = true;
                break;
            }
        }
        if (isChaos)
            System.out.println("Too chaotic");
        else {
            System.out.println(bribes(q).count);
        }

    }

    private static Storage bribes(int[] q) {
        int start = 0;
        int end = q.length - 1;
        if (start >= end) {
            Storage storage = new Storage();
            storage.q = q;
            storage.count = 0;
            return storage;
        } else {
            int mid = (start + end) / 2;
            int[] leftArray = Arrays.copyOfRange(q, start, mid + 1);
            int[] rightArray = Arrays.copyOfRange(q, mid + 1, end + 1);
            Storage left = bribes(leftArray);
            Storage right = bribes(rightArray);
            Storage total = storageMerge(left, right);
            total.count += left.count;
            total.count += right.count;
            return total;
        }
    }

    private static Storage storageMerge(Storage left, Storage right) {
        int[] l = left.q;
        int[] r = right.q;
        int[] merged = new int[l.length + r.length];
        int i = 0;
        int j = 0;
        int k = 0;
        int count = 0;
        while (i < l.length && j < r.length) {
            if (l[i] < r[j]) {
                merged[k++] = l[i++];
            } else {
                merged[k++] = r[j++];
                count += (l.length - i);
            }
        }
        System.arraycopy(left.q, i, merged, k, left.q.length - i);
        System.arraycopy(right.q, j, merged, k, right.q.length - j);

        Storage total = new Storage();
        total.q = merged;
        total.count = count;
        return total;
    }

    static class Storage {
        public int[] q;
        public int count;
    }

    public static void main(String[] args) {
        //minimumBribes(new int[]{3, 2, 1});
        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
        //minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
    }
}
