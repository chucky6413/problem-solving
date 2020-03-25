package leetcode;

import java.util.PriorityQueue;

public class Solution1387 {
	private int[] dp = new int[1001];

	public int getKth(int lo, int hi, int k) {
		PriorityQueue<Node> rs = new PriorityQueue<>();
		for (int x = lo; x <= hi; x++) {
			rs.offer(new Node(x, calculatePowerValue(x)));
			if (rs.size() > k) {
				rs.poll();
			}
		}
		return rs.peek().x;
	}

	private int calculatePowerValue(int x) {
		if (dp[x] != 0) {
			return dp[x];
		}
		int cur = x;
		int cnt = 0;
		while (cur != 1) {
			cnt++;
			if (cur % 2 == 0) {
				cur /= 2;
			} else {
				cur = 3 * cur + 1;
			}
		}
		dp[x] = cnt;
		return cnt;
	}

	static class Node implements Comparable<Node> {
		int x;
		int powerValue;

		public Node(int x, int powerValue) {
			this.x = x;
			this.powerValue = powerValue;
		}

		@Override
		public int compareTo(Node other) {
			if (powerValue == other.powerValue) {
				return other.x - x;
			}
			return other.powerValue - powerValue;
		}
	}
}