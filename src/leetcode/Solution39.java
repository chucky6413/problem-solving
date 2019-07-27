package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rs = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), rs);
        return rs;
    }

    private void backtrack(int start, int remainVal, int[] candidates, List<Integer> curList, List<List<Integer>> result) {
        if (remainVal == 0) {
            result.add(new ArrayList<>(curList));
            return;
        }

        for (int i = start; i < candidates.length && remainVal >= candidates[i]; i++) {
            curList.add(candidates[i]);
            backtrack(i, remainVal - candidates[i], candidates, curList, result);
            curList.remove(curList.size() - 1);
        }
    }
}