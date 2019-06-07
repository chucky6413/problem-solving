package leetcode;

import java.util.*;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        List<Integer> inter = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                inter.add(nums2[i]);
                int c = map.get(nums2[i]);
                if (c == 1) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], c - 1);
                }
            }
        }

        int[] rs = new int[inter.size()];
        int idx = 0;
        for (Integer i : inter) {
            rs[idx++] = i;
        }
        return rs;
    }
}