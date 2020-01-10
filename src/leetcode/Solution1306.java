package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1306 {
	public boolean canReach(int[] arr, int start) {
		int len = arr.length;
		boolean[] visited = new boolean[len];

		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (arr[cur] == 0) {
				return true;
			}

			int[] nexts = new int[] {cur + arr[cur], cur - arr[cur]};
			for (int next : nexts) {
				if (0 <= next && next < len && !visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}

		return false;
	}
}