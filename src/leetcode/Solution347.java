package leetcode;

import java.util.*;

/**
 * My solution has nlogk time complexity.
 * <p>
 * Other good solution link
 * - https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort
 */

public class Solution347 {
    class ElementWrapper {
        int e;
        int count;

        public ElementWrapper(int e, int count) {
            this.e = e;
            this.count = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<ElementWrapper> queue = new PriorityQueue<>((e1, e2) -> e1.count - e2.count);
        for (int element : map.keySet()) {
            queue.offer(new ElementWrapper(element, map.get(element)));
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<Integer> rs = new ArrayList<>();
        while (!queue.isEmpty()) {
            rs.add(queue.poll().e);
        }
        return rs;
    }
}