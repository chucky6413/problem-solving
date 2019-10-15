package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1218 {
    public int longestSubsequence(int[] arr, int diff) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = Integer.MIN_VALUE;
        for (int n : arr) {
            int len = map.getOrDefault(n - diff, 0) + 1;
            map.put(n, len);
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}