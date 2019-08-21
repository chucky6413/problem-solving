package leetcode;

public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                res = Math.max(res, ++len);
            } else {
                len = 1;
            }
        }
        return res;
    }
}