import java.util.*;

/*
 * @problem https://leetcode.com/problems/3sum/description/
 * @author chucky6413
 */

public class Solution15 {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                findRestTwo(nums, i);
            }
        }

        return result;
    }

    public void findRestTwo(int[] nums, int first) {
        int left = first + 1;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] + nums[right] == -nums[first]) {
                result.add(Arrays.asList(nums[first], nums[left++], nums[right--]));

                while (left < nums.length - 1 && nums[left] == nums[left - 1]) {
                    left++;
                }

                while (right > first && nums[right] == nums[right + 1]) {
                    right--;
                }

            } else if (nums[left] + nums[right] < -nums[first]) {
                left++;
            } else {
                right--;
            }
        }
    }
}