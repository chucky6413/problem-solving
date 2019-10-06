package leetcode;

public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int startIdx = 0;
        int maximumLen = 0;
        int remainCost = maxCost;
        for (int i = 0; i < cost.length; i++) {
            remainCost -= cost[i];
            while (remainCost < 0) {
                remainCost += cost[startIdx];
                startIdx += 1;
            }

            maximumLen = Math.max(i - startIdx + 1, maximumLen);
        }

        return maximumLen;
    }
}