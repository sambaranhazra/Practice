package com.company

import java.math.BigInteger

fun search(a: Array<Int>, key: Int) {
    print(searchRecursively(a, key))
}

private tailrec fun searchRecursively(a: Array<Int>, key: Int, low: Int = 0, high: Int = a.size): Int {
    if (low < high) {
        val mid = (high + low) / 2
        return when {
            key == a[mid] -> key
            key < a[mid] -> searchRecursively(a, key, low, mid - 1)
            else -> searchRecursively(a, key, mid + 1, high)
        }
    }
    return -1
}

tailrec fun factorial(n: Int, acc: BigInteger): BigInteger {
    return if (n == 1) acc
    else factorial(n - 1, acc.times(BigInteger.valueOf(n.toLong())))
}

fun main() {
    search(arrayOf(1, 2, 3, 5), 5)
    //print(factorial(10000, BigInteger.ONE))
    //print(factorialRecursive(100000))
}

fun factorialRecursive(i: Int): BigInteger {
    return if (i == 1) BigInteger.ONE
    else factorialRecursive(i - 1).times(i.toBigInteger())
}
