import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    private List<List<Integer>> rs = new ArrayList<>();
    private boolean[] hasNum;

    public List<List<Integer>> permute(int[] nums) {
        hasNum = new boolean[nums.length];
        backTrack(new ArrayList<>(), nums, 0);
        return rs;
    }

    private void backTrack(List<Integer> subList, int[] nums, int start) {
        if (nums.length == subList.size()) {
            rs.add(new ArrayList(subList));
            return;
        }

        for (int i = start; i < start + nums.length; i++) {
            int index = i % nums.length;
            if (!hasNum[index]) {
                hasNum[index] = true;
                subList.add(nums[index]);
                backTrack(subList, nums, start + 1);
                subList.remove(subList.size() - 1);
                hasNum[index] = false;
            }
        }
    }
}