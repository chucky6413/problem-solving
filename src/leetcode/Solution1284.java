package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution1284 {
	private int m, n;

	class Node {
		int[][] mat;
		int cnt;

		public Node(int[][] mat, int cnt) {
			this.mat = mat;
			this.cnt = cnt;
		}
	}

	public int minFlips(int[][] mat) {
		m = mat.length;
		n = mat[0].length;

		int res = -1;

		Set<String> visit = new HashSet<>();
		visit.add(makeKey(mat));

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(mat, 0));
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (isZero(cur.mat)) {
				return cur.cnt;
			}

			for (int r = 0; r < m; r++) {
				for (int c = 0; c < n; c++) {
					int[][] t = deepCopy(cur.mat);
					flip(r, c, t);

					if (!visit.contains(makeKey(t))) {
						visit.add(makeKey(t));
						q.offer(new Node(t, cur.cnt + 1));
					}
				}
			}
		}

		return res;
	}

	private boolean isZero(int[][] mat) {
		for (int[] rows : mat) {
			for (int c = 0; c < mat[0].length; c++) {
				if (rows[c] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private String makeKey(int[][] mat) {
		StringBuilder sb = new StringBuilder();
		for (int[] rows : mat) {
			for (int c = 0; c < mat[0].length; c++) {
				sb.append(rows[c]).append("/");
			}
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}

	private void flip(int r, int c, int[][] mat) {
		mat[r][c] ^= 1;

		if (r + 1 < m) {
			mat[r + 1][c] ^= 1;
		}
		if (r - 1 >= 0) {
			mat[r - 1][c] ^= 1;
		}
		if (c + 1 < n) {
			mat[r][c + 1] ^= 1;
		}
		if (c - 1 >= 0) {
			mat[r][c - 1] ^= 1;
		}
	}

	private int[][] deepCopy(int[][] mat) {
		final int[][] copy = new int[mat.length][];
		for (int i = 0; i < mat.length; i++) {
			copy[i] = Arrays.copyOf(mat[i], mat[i].length);
		}
		return copy;
	}
}