package codejam.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution2020B_1 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[] H = new int[N];
			for (int j = 0; j < N; j++) {
				H[j] = sc.nextInt();
			}

			rs.append(String.format("Case #%d: ", i))
				.append(solve(N, H))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static int solve(int n, int[] h) {
		int peakCnt = 0;
		for (int j = 1; j < n - 1; j++) {
			if (h[j] > h[j - 1] && h[j] > h[j + 1]) {
				peakCnt++;
			}
		}
		return peakCnt;
	}
}