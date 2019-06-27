package leetcode.kotlin

class Solution136 {
    fun singleNumber(nums: IntArray) = nums.reduce { a, b -> a xor b }
}