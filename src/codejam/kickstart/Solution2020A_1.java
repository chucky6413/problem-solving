package codejam.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2020A_1 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			int[] A = new int[N];
			for (int j = 0; j < N; j++) {
				A[j] = sc.nextInt();
			}

			rs.append(String.format("Case #%d: ", i))
				.append(solve(N, B, A))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static int solve(int N, int B, int[] A) {
		Arrays.sort(A);
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (A[i] <= B) {
				cnt++;
				B -= A[i];
			}
		}
		return cnt;
	}
}