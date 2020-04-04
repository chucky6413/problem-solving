package codejam.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution2020_Q_1 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] M = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					M[i][j] = sc.nextInt();
				}
			}

			rs.append(String.format("Case #%d: ", t))
				.append(solve(N, M))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static String solve(int N, int[][] M) {
		int k = 0;
		int r = 0;
		int c = 0;

		for (int i = 0; i < N; i++) {
			Set<Integer> row = new HashSet<>();
			Set<Integer> col = new HashSet<>();
			for (int j = 0; j < N; j++) {
				if (i == j) {
					k += M[i][j];
				}
				row.add(M[i][j]);
				col.add(M[j][i]);
			}
			if (row.size() < N) {
				r++;
			}
			if (col.size() < N) {
				c++;
			}
		}

		return k + " " + r + " " + c;
	}
}