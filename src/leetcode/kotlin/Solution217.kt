package leetcode.kotlin

class Solution217 {
    fun containsDuplicate(nums: IntArray) = nums.size != nums.toSet().size
}