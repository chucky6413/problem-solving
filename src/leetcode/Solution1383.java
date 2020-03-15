package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1383 {
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		int[][] engineers = new int[n][2];
		for (int i = 0; i < n; i++) {
			engineers[i][0] = efficiency[i];
			engineers[i][1] = speed[i];
		}
		Arrays.sort(engineers, (e1, e2) -> e2[0] - e1[0]);
		PriorityQueue<Integer> speeds = new PriorityQueue<>();

		long rs = 0;
		long speedSum = 0;
		for (int[] e : engineers) {
			speeds.offer(e[1]);
			speedSum = (speedSum + e[1]);
			if (speeds.size() > k) {
				speedSum -= speeds.poll();
			}
			rs = Math.max(speedSum * e[0], rs);
		}
		return (int)(rs % (long)(1e9 + 7));
	}
}