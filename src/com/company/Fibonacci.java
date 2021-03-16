package com.company;

import java.math.BigInteger;
import java.util.HashMap;

public class Fibonacci {

    public static BigInteger fibo(int num, HashMap<Integer, BigInteger> memo) {
        if (memo.containsKey(num)) return memo.get(num);
        if (num <= 2) return BigInteger.ONE;
        else memo.put(num, fibo(num - 1, memo).add(fibo(num - 2, memo)));
        return memo.get(num);
    }

    public static BigInteger fiboTabulation(int num) {
        if (num <= 1) return BigInteger.ONE;
        BigInteger[] table = new BigInteger[num];
        table[0] = BigInteger.ONE;
        table[1] = BigInteger.ONE;
        for (int i = 2; i < num; i++) {
            table[i] = table[i - 1].add(table[i - 2]);
        }
        return table[num - 1];
    }

    public static void main(String[] args) {
        System.out.println(fiboTabulation(100));
    }
}
