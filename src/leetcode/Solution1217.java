package leetcode;

public class Solution1217 {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        for (int pos : chips) {
            if (pos % 2 == 1) odd++;
            else even++;
        }
        return Math.min(odd, even);
    }
}