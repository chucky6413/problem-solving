package leetcode;

import java.util.*;

/*
 * @problem https://leetcode.com/problems/3sum/description/
 * @author chucky6413
 */

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int a = nums[i];

                // find two (b, c)
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int b = nums[left];
                    int c = nums[right];

                    if (b + c == -a) {
                        rs.add(Arrays.asList(a, b, c));

                        while (left < right && b == nums[left]) {
                            left++;
                        }
                        while (left < right && c == nums[right]) {
                            right--;
                        }
                    } else if (b + c > -a) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return rs;
    }
}