package leetcode;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            cur = cur > 0 ? cur + nums[i] : nums[i];
            max = Math.max(cur, max);
        }

        return max;
    }
}