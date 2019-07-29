package leetcode;

public class Solution724 {
    public int pivotIndex(int[] nums) {
        int[] sumFromLeft = new int[nums.length];
        int[] sumFromRight = new int[nums.length];

        int lastIdx = nums.length - 1;
        for (int i = 0; i <= lastIdx; i++) {
            if (i == 0) {
                sumFromLeft[i] = nums[0];
                sumFromRight[lastIdx] = nums[lastIdx];
            } else {
                sumFromLeft[i] = nums[i] + sumFromLeft[i - 1];
                sumFromRight[lastIdx - i] = nums[lastIdx - i] + sumFromRight[lastIdx - i + 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (sumFromLeft[i] == sumFromRight[i]) {
                return i;
            }
        }

        return -1;
    }
}