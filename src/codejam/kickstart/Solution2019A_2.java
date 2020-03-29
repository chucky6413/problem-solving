package codejam.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution2019A_2 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String NEW_LINE = "\n";

	private static final int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			int[][] sq = new int[R][C];
			for (int r = 0; r < R; r++) {
				int idx = 0;
				for (char c : sc.next().toCharArray()) {
					sq[r][idx++] = Integer.parseInt(c + "");
				}
			}
			rs.append(String.format("Case #%d: ", i))
				.append(solve(R, C, sq))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static int solve(int R, int C, int[][] sq) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] seen = new boolean[R][C];
		List<int[]> zeroList = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (sq[r][c] == 1) {
					q.offer(new int[] {r, c, 0});
					seen[r][c] = true;
				} else {
					zeroList.add(new int[] {r, c});
				}
			}
		}

		boolean isNotExistOffice = false;
		if (zeroList.size() == 0) {
			return 0;
		} else if (q.size() == 0) {
			seen[R / 2][C / 2] = true;
			q.offer(new int[] {R / 2, C / 2, 0});
			isNotExistOffice = true;
		}

		List<List<int[]>> timeList = new ArrayList<>();
		for (int i = 0; i <= 500000; i++) {
			timeList.add(new ArrayList<>());
		}
		int maxTime = 0;
		while (!q.isEmpty()) {
			int[] t = q.poll();
			for (int[] dir : dirs) {
				int nextRow = t[0] + dir[0];
				int nextCol = t[1] + dir[1];
				int nextTime = t[2] + 1;

				if (((0 <= nextRow && nextRow < R)
					&& (0 <= nextCol && nextCol < C))
					&& !seen[nextRow][nextCol]) {

					// for bfs
					seen[nextRow][nextCol] = true;
					q.offer(new int[] {nextRow, nextCol, nextTime});

					// for binary search
					maxTime = Math.max(nextTime, maxTime);
					timeList.get(nextTime).add(new int[] {nextRow, nextCol});
				}
			}
		}

		if (isNotExistOffice) {
			return maxTime;
		}

		int left = 0;
		int right = maxTime;
		int rs = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean toLeft = false;
			boolean toRight = false;

			for (int[] zero : zeroList) {
				for (int i = mid + 1; i <= maxTime; i++) {
					for (int[] pos : timeList.get(i)) {
						int t = Math.abs(pos[0] - zero[0]) + Math.abs(pos[1] - zero[1]);
						if (t > mid) {
							toRight = true;
							break;
						}
					}
					if (toRight) {
						break;
					}
				}

				if (!toRight) {
					toLeft = true;
					break;
				}
				toRight = false;
			}

			if (toLeft) {
				rs = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return rs;
	}
}