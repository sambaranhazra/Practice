package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxSubSelectSum {

    static int maxSubSelectSum(int[] numbers, int len, Map<Integer, Integer> memo) {
        if (len <= 0) return 0;
        if (memo.containsKey(len)) return memo.get(len);
        int sum = 0;
        int otherLimit = len - 2;
        do {
            sum = Math.max(sum, maxSubSelectSum(numbers, otherLimit--, memo) + numbers[len - 1]);
        } while (otherLimit >= 0);
        memo.put(len, sum);
        return sum;
    }

    static int maxSubsetSum(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;
        Map<Integer, Integer> memo = new HashMap<>();
        int maxSum = 0;
        for (int i = numbers.length; i > 0; i--) {
            int runningSum = maxSubSelectSum(numbers, i, memo);
            if (runningSum > maxSum) maxSum = runningSum;
        }
        return maxSum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(maxSubsetSumTabulation(getValues()));
    }

    private static int maxSubsetSumTabulation(int[] values) {
        if (values == null || values.length == 0) return 0;
        int[] result = new int[values.length];
        System.arraycopy(values, 0, result, 0, values.length);
        int currentMax = 0;
        for (int i = 2; i < values.length; i++) {
            int prevMax = 0;
            for (int j = 0; j <= i - 2; j++) {
                prevMax = Math.max(prevMax, result[j]);
            }

            result[i] = Math.max(Math.max(result[i], prevMax + values[i]), currentMax);
            currentMax = result[i];
        }
        return currentMax;
    }

    private static int[] getValues() throws FileNotFoundException {
        final Scanner scanner = new Scanner(new FileReader("D:\\projects\\IdeaProjects\\Practice\\test_data.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        scanner.close();
        return arr;
    }
}
