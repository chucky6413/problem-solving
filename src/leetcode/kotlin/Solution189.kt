package leetcode.kotlin

class Solution189 {
    fun rotate(nums: IntArray, k: Int) {
        val step = k % nums.size
        reverse(nums, 0, nums.size - step - 1)
        reverse(nums, nums.size - step, nums.size - 1)
        reverse(nums, 0, nums.size - 1)
    }

    private fun reverse(nums: IntArray, start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            nums[left] = nums[right].also { nums[right] = nums[left] }
            left++
            right--
        }
    }
}