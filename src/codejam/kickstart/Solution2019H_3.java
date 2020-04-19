package codejam.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution2019H_3 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int[] arr = new int[10];
			for (int j = 1; j < 10; j++) {
				arr[j] = sc.nextInt();
			}

			rs.append(String.format("Case #%d: ", i))
				.append(solve(arr))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static String solve(int[] arr) {
		int numsCnt = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > 20) {
				arr[i] = arr[i] % 2 == 0 ? 20 : 19;
			}
			numsCnt += arr[i];
		}

		boolean[][][] memo = new boolean[11][11][1001];
		boolean[][][] seen = new boolean[11][11][1001];
		return recur(memo, seen, arr, 1, 0, 0, numsCnt) ? "YES" : "NO";
	}

	private static boolean recur(boolean[][][] memo, boolean[][][] seen, int[] arr, int idx, int remainder,
		int negativesCntSum, int numsCnt) {
		if (idx == 10) {
			return remainder == 0 && negativesCntSum == (numsCnt / 2);
		}

		if (seen[idx][remainder][negativesCntSum]) {
			return memo[idx][remainder][negativesCntSum];
		}

		boolean possible = false;

		for (int positveCnt = 0; positveCnt <= arr[idx]; positveCnt++) {
			int negativeCnt = arr[idx] - positveCnt;
			int newRemainder = (remainder + (positveCnt * idx) % 11 - (negativeCnt * idx) % 11 + 11) % 11;
			possible |= recur(memo, seen, arr, idx + 1, newRemainder, negativesCntSum + negativeCnt, numsCnt);
		}

		memo[idx][remainder][negativesCntSum] = possible;
		seen[idx][remainder][negativesCntSum] = true;
		return possible;
	}
}