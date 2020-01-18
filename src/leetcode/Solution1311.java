package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution1311 {
	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
		int n = watchedVideos.size();
		boolean[] visited = new boolean[n];

		Queue<Integer> q = new LinkedList<>();
		q.offer(id);
		visited[id] = true;
		while (level-- > 0) {
			int size = q.size();
			while (size-- > 0) {
				int fid = q.poll();
				for (int f : friends[fid]) {
					if (!visited[f]) {
						q.offer(f);
						visited[f] = true;
					}
				}
			}
		}

		Map<String, Integer> cnt = new HashMap<>();
		while (!q.isEmpty()) {
			int fid = q.poll();
			for (String v : watchedVideos.get(fid)) {
				cnt.put(v, cnt.getOrDefault(v, 0) + 1);
			}
		}

		List<String> rs = new ArrayList<>(cnt.keySet());
		rs.sort(
			(v1, v2) -> {
				int cnt1 = cnt.get(v1);
				int cnt2 = cnt.get(v2);
				if (cnt1 == cnt2) {
					return v1.compareTo(v2);
				}
				return cnt1 - cnt2;
			}
		);
		return rs;
	}
}