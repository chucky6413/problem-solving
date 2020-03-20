package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution1046 {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int stone : stones) {
			pq.offer(stone);
		}

		while (pq.size() > 1) {
			int x = pq.poll();
			int y = pq.poll();

			int remain = x - y;
			if (remain != 0) {
				pq.offer(remain);
			}
		}

		return pq.size() == 0 ? 0 : pq.poll();
	}
}