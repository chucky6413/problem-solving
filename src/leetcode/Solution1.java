package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @problem https://leetcode.com/problems/two-sum/description/
 * @author chucky6413
 */

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]) && i != hashMap.get(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
        }

        return new int[]{-1, -1};
    }
}