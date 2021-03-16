package com.company

fun move(row: Int, col: Int, dp: Array<Array<Int>>): Int {
    if (dp[row][col] != 0) return dp[row][col]
    dp[1][1] = 1
    if (row > 0)
        dp[row][col] += move(row - 1, col, dp)
    if (col > 0)
        dp[row][col] += move(row, col - 1, dp)
    return dp[row][col]
}

fun main() {
    val row = 1
    val col = 1
    println(move(row, col, Array(row + 1) { Array(col + 1) { 0 } }))
}