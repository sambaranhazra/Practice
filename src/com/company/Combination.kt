package com.company

import java.math.BigInteger

fun choose(num: Long, kk: Long): BigInteger {
    var n = num
    var k = kk
    var acc = BigInteger.ONE
    while (k > 0L) {
        acc = acc.multiply(BigInteger.valueOf(n)).divide(BigInteger.valueOf(k))
        n -= 1
        k -= 1
    }
    return acc
}

fun main() {
    print(choose(100000, 20000))
}