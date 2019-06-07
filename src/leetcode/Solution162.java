package leetcode;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (mid == 0 || mid == nums.length - 1 || nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                if (mid == 0 && right - left == 1 && nums[mid] < nums[mid + 1]) {
                    return mid + 1;
                }
                return mid;
            }

            if (nums[mid - 1] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}