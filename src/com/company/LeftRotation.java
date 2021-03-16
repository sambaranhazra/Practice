package com.company;

import java.util.Arrays;

public class LeftRotation {
    static int[] rotLeft(int[] a, int d) {
        int size = a.length;
        if (d > size / 2)
            return rightRotate(a, size - d);
        else
            return leftRotate(a, d);
    }

    private static int[] rightRotate(int[] a, int d) {
        while (d > 0) {
            int temp = a[a.length - 1];
            System.arraycopy(a, 0, a, 1, a.length - 1);
            a[0] = temp;
            d--;
        }
        return a;
    }

    private static int[] leftRotate(int[] a, int d) {
        while (d > 0) {
            int temp = a[0];
            for (int i = 0; i < a.length - 1; i++) {
                a[i] = a[i + 1];
            }
            a[a.length - 1] = temp;
            d--;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotLeft(new int[]{1, 2, 3, 4, 5}, 4)));
    }
}
