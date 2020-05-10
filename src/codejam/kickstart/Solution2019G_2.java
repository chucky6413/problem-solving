package codejam.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution2019G_2 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			long M = sc.nextLong();
			long[] A = new long[N];
			for (int j = 0; j < N; j++) {
				A[j] = sc.nextLong();
			}

			rs.append(String.format("Case #%d: ", i))
				.append(solve(N, M, A))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static long solve(int N, long M, long[] A) {
		int[] bitCnts1 = new int[51];
		int[] bitCnts0 = new int[51];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= 50; j++) {
				if (((A[i] >> j) & 1L) != 0) {
					bitCnts1[j]++;
				} else {
					bitCnts0[j]++;
				}
			}
		}

		for (int i = 0; i <= 50; i++) {
			M -= (long)Math.min(bitCnts0[i], bitCnts1[i]) << i;
		}

		if (M < 0) {
			return -1L;
		}

		long k = 0;

		for (int i = 50; i >= 0; i--) {
			if (bitCnts1[i] >= bitCnts0[i]) {
				k |= (1L << i);
			} else if (M >= (long)(bitCnts0[i] - bitCnts1[i]) << i) {
				M -= (long)(bitCnts0[i] - bitCnts1[i]) << i;
				k |= (1L << i);
			}
		}

		return k;
	}
}