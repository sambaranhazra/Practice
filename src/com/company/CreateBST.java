package com.company;

import java.util.stream.IntStream;

public class CreateBST {
    static Node generateBST(int[] arr, int start, int end) {
        if (start >= end)
            return null;
        int mid = (start + end) / 2;
        Node n = new Node();
        n.value = arr[mid];
        n.left = generateBST(arr, start, mid);
        n.right = generateBST(arr, mid + 1, end);
        return n;
    }

    static void print(Node root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.printf("%s -> ", root.value);
        print(root.right);
    }

    private static class Node {
        int value;
        Node left;
        Node right;
    }

    public static void main(String[] args) {
        int[] ints = IntStream.rangeClosed(0, 1000000).toArray();
        Node n = generateBST(ints, 0, ints.length);
    }
}
