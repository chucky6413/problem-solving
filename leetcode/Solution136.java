/*
 * @problem https://leetcode.com/problems/single-number/description/
 * @author chucky6413
 */

public class Solution136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}