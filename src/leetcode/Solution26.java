package leetcode;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int fv = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > fv) {
                nums[index++] = fv = nums[i];
            }
        }

        return index;
    }
}