package leetcode.kotlin

class Solution350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums1.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        val rs = mutableListOf<Int>()
        nums2.forEach {
            if (map.containsKey(it) && map[it]!! > 0) {
                map[it] = map[it]!! - 1
                rs.add(it)
            }
        }
        return rs.toIntArray()
    }
}