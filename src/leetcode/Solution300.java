package leetcode;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] increasingSeq = new int[nums.length];

        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || increasingSeq[len - 1] < nums[i]) {
                increasingSeq[len++] = nums[i];
            } else {
                int pos = findIdxToReplace(increasingSeq, len, nums[i]);
                increasingSeq[pos] = nums[i];
            }
        }

        return len;
    }

    private int findIdxToReplace(int[] increasingSeq, int len, int target) {
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (increasingSeq[mid] == target) {
                return mid;
            } else if (increasingSeq[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}