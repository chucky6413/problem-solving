package leetcode;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestVal = nums[0] + nums[1] + nums[nums.length - 1];
        for (int fixedIdx = 0; fixedIdx < nums.length - 2; fixedIdx++) {
            int left = fixedIdx + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[fixedIdx] + nums[left] + nums[right];

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return target;
                }

                if (Math.abs(target - sum) < Math.abs(target - closestVal)) {
                    closestVal = sum;
                }
            }
        }

        return closestVal;
    }
}