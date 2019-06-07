package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int majorElm = 0;
        for (int num : nums) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 0);
            }
            countMap.put(num, countMap.get(num) + 1);
            majorElm = countMap.getOrDefault(majorElm, 0) > countMap.get(num) ? majorElm : num;
        }
        return majorElm;
    }
}