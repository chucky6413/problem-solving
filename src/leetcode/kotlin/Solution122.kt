package leetcode.kotlin

class Solution122 {
    fun maxProfit(prices: IntArray) = (1 until prices.size)
            .sumBy { maxOf(0, prices[it] - prices[it - 1]) }
}