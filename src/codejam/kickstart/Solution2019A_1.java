package codejam.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2019A_1 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int P = sc.nextInt();
			int[] S = new int[N];
			for (int j = 0; j < N; j++) {
				S[j] = sc.nextInt();
			}

			rs.append(String.format("Case #%d: ", i))
				.append(solve(N, P, S))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static int solve(int N, int P, int[] S) {
		Arrays.sort(S);
		int sum = 0;
		for (int i = 0; i < P - 1; i++) {
			sum += S[i];
		}

		int rs = Integer.MAX_VALUE;
		for (int i = P - 1; i < N; i++) {
			sum += S[i];
			int cur = (S[i] * P) - sum;
			rs = Math.min(cur, rs);
			sum -= S[i - P + 1];
		}
		return rs;
	}
}