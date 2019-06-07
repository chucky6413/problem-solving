package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), rs);
        return rs;
    }

    private void backtrack(int[] nums, int cur, List<Integer> subList, List<List<Integer>> rs) {
        rs.add(new ArrayList<>(subList));
        for (int i = cur; i < nums.length; i++) {
            subList.add(nums[i]);
            backtrack(nums, i + 1, subList, rs);
            subList.remove(subList.size() - 1);
        }
    }
}