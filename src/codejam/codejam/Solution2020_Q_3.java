package codejam.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution2020_Q_3 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] times = new int[N][2];
			for (int i = 0; i < N; i++) {
				times[i][0] = sc.nextInt();
				times[i][1] = sc.nextInt();
			}

			rs.append(String.format("Case #%d: ", t))
				.append(solve(times))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static String solve(int[][] times) {
		List<Task> tasks = new ArrayList<>();
		for (int i = 0; i < times.length; i++) {
			tasks.add(new Task(times[i][0], times[i][1], i));
		}
		Collections.sort(tasks);

		char[] rs = new char[times.length];
		Task cameron = new Task(0, 0, 0);
		Task jamie = new Task(0, 0, 0);
		for (Task t : tasks) {
			if (cameron.end <= t.start) {
				cameron = t;
				rs[t.idx] = 'C';
			} else if (jamie.end <= t.start) {
				jamie = t;
				rs[t.idx] = 'J';
			} else {
				return "IMPOSSIBLE";
			}
		}

		return String.valueOf(rs);
	}

	private static class Task implements Comparable<Task> {
		int start;
		int end;
		int idx;

		public Task(int start, int end, int idx) {
			this.start = start;
			this.end = end;
			this.idx = idx;
		}

		@Override
		public int compareTo(Task other) {
			if (this.start == other.start) {
				return this.end - other.end;
			}
			return this.start - other.start;
		}
	}
}