package leetcode;

import java.util.Arrays;

public class Solution1334 {
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int[][] dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], 10001);
		}

		for (int[] edge : edges) {
			dist[edge[0]][edge[1]] = edge[2];
			dist[edge[1]][edge[0]] = edge[2];
		}

		for (int i = 0; i < n; i++) {
			dist[i][i] = 0;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
				}
			}
		}

		int rs = 0;
		int smallest = 10000;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (dist[i][j] <= distanceThreshold) {
					cnt++;
				}
			}
			if (cnt <= smallest) {
				smallest = cnt;
				rs = i;
			}
		}
		return rs;
	}
}