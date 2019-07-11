package leetcode.kotlin

class Solution35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                (nums[mid] == target) -> return mid
                (nums[mid] < target) -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return left
    }
}