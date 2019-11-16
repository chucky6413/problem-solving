package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int e : A) {
            pq.offer(e);
        }

        while (K-- > 0) {
            int e = pq.poll();
            pq.offer(-e);
        }

        int sum = 0;
        for (Object e : pq.toArray()) {
            sum += (Integer) e;
        }
        return sum;
    }
}