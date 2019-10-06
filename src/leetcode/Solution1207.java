package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int e : arr) {
            cntMap.put(e, cntMap.getOrDefault(e, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int cnt : cntMap.values()) {
            if (set.contains(cnt)) {
                return false;
            }
            set.add(cnt);
        }
        return true;
    }
}