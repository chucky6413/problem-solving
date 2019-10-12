package leetcode;

public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int curCost = 0;
        int maxLength = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int cost = Math.abs(s.charAt(r) - t.charAt(r));

            while (l <= r && curCost + cost > maxCost) {
                curCost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }

            if (curCost + cost <= maxCost) {
                curCost += cost;
                maxLength = Math.max(r - l + 1, maxLength);
            }
        }

        return maxLength;
    }
}