package leetcode;

public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int n : nums) {
            n = Math.abs(n);
            if (nums[n - 1] < 0) {
                res[0] = n;
            } else {
                nums[n - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
            }
        }

        return res;
    }
}