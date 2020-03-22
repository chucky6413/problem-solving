package codejam.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution2020A_2 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int P = sc.nextInt();
			int[][] A = new int[N][K];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < K; k++) {
					A[j][k] = sc.nextInt();
				}
			}

			rs.append(String.format("Case #%d: ", i))
				.append(solve(N, K, P, A))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static int solve(int N, int K, int P, int[][] A) {
		int[][] sum = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j == 1) {
					sum[i][j] = A[i - 1][j - 1];
				} else {
					sum[i][j] = sum[i][j - 1] + A[i - 1][j - 1];
				}
			}
		}

		int[][] dp = new int[N + 1][P + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= P; j++) {
				for (int x = 0; x <= Math.min(j, K); x++) {
					dp[i][j] = Math.max(dp[i - 1][j - x] + sum[i][x], dp[i][j]);
				}
			}
		}

		return dp[N][P];
	}
}