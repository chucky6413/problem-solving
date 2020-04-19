package codejam.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution2020B_2 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			long D = sc.nextLong();
			long[] X = new long[N];
			for (int j = 0; j < N; j++) {
				X[j] = sc.nextLong();
			}

			rs.append(String.format("Case #%d: ", i))
				.append(solve(N, D, X))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static long solve(int n, long d, long[] x) {
		for (int i = n - 1; i >= 0; i--) {
			d = (d / x[i]) * x[i];
		}
		return d;
	}
}