package leetcode.kotlin

fun main(args: Array<String>) {
    val sol = Solution11()
    val heights = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(sol.maxArea(heights))
}

class Solution11 {
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.size - 1

        while (left < right) {
            maxArea = maxOf(maxArea, (right - left) * minOf(height[left], height[right]))
            when {
                height[left] < height[right] -> left++
                else -> right--
            }
        }
        return maxArea
    }
}