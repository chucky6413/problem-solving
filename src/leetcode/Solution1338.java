package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1338 {
	public int minSetSize(int[] arr) {
		Map<Integer, Integer> cnt = new HashMap<>();
		for (int e : arr) {
			cnt.put(e, cnt.getOrDefault(e, 0) + 1);
		}

		Queue<Node> q = new PriorityQueue<>();
		for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
			q.offer(new Node(e.getKey(), e.getValue()));
		}

		int rs = 0;
		int len = arr.length;
		while (len > arr.length / 2) {
			Node n = q.poll();
			len -= n.cnt;
			rs++;
		}
		return rs;
	}

	static class Node implements Comparable<Node> {
		int num;
		int cnt;

		Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node other) {
			return other.cnt - cnt;
		}
	}
}