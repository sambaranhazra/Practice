package com.company

import kotlin.math.max

fun maximumProfit(
    prices: Array<Int>,
    dp: Array<Array<Int>>,
    start: Int = 0,
    end: Int = prices.size - 1,
    year: Int = 1
): Int {
    if (dp[start][end] != -1) return dp[start][end]
    if (start == end) return year * prices[start]
    else {
        val left = (year * prices[start]) + maximumProfit(prices, dp, start + 1, end, year + 1)
        val right = (year * prices[end]) + maximumProfit(prices, dp, start, end - 1, year + 1)
        dp[start][end] = max(left, right)
    }
    return dp[start][end]
}

fun maximumProfitIter(prices: Array<Int>): Int {
    val arraySize = prices.size + 1
    val t: Array<Array<Int>> = Array(arraySize) { Array(arraySize) { 0 } }

    for (i in 0 until arraySize) {
        for (j in 0 until arraySize) {
            if (i == j)
                t[i + 1][j + 1] = prices[i] * (i + 1)
        }
    }
    return -1
}

fun main() {
    val prices = arrayOf(
        2,
        4,
        6,
        2,
        5,
        2,
        4,
        6,
        2,
        5,
        2,
        4,
        6,
        2,
        5,
        2,
        4,
        6,
        2,
        5,
        2,
        4,
        6,
        2,
        5,
        2,
        4,
        6,
        2,
        5,
    )
    val dp = Array(prices.size) { Array(prices.size) { -1 } }
    println(
        maximumProfit(prices, dp)
    )
}