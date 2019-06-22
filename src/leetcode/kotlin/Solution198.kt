package leetcode.kotlin

/**
 * @author jw.lee
 * @email chucky6413@gmail.com
 */

fun main(args: Array<String>) {
    val solution = Solution198()
    print(12 == solution.rob(intArrayOf(2, 7, 9, 3, 1)))
}

class Solution198 {
    fun rob(nums: IntArray): Int {
        val dp = IntArray(nums.size + 1)
        for (i in 1 until dp.size) {
            dp[i] = if (i == 1) nums[0]
                    else maxOf(dp[i - 2] + nums[i - 1], dp[i - 1])
        }
        return dp.last()
    }
}