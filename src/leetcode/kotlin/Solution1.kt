package leetcode.kotlin

class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            val o = target - nums[i]
            if (map.contains(o)) {
                return intArrayOf(map[o]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf(-1, -1)
    }
}