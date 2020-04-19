package codejam.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution2020B_3 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			String s = sc.next();

			rs.append(String.format("Case #%d: ", i))
				.append(solve(s))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static final int MOD = (int)1e9;

	private static String solve(String s) {
		char[] cArr = s.toCharArray();
		long[] rs = solve(cArr, 0, s.length() - 1);
		return (rs[0] + 1) + SPACE + (rs[1] + 1);
	}

	private static long[] solve(char[] cArr, int cur, int end) {
		long[] rs;
		long[] from;
		if (cur == end) {
			from = new long[] {0, 0};
			rs = move(from, cArr[cur]);
		} else if (cArr[cur] >= '2' && cArr[cur] <= '9') {
			long times = cArr[cur] - '0';

			int idx = cur + 1;
			int cnt = 1;
			while (cnt > 0) {
				idx++;
				if (cArr[idx] == '(') {
					cnt++;
				} else if (cArr[idx] == ')') {
					cnt--;
				}
			}
			rs = solve(cArr, cur + 2, idx - 1);
			rs[0] = (rs[0] * times) % MOD;
			rs[1] = (rs[1] * times) % MOD;

			if (idx + 1 <= end) {
				long[] nxtRs = solve(cArr, idx + 1, end);
				rs[0] = (rs[0] + nxtRs[0]) % MOD;
				rs[1] = (rs[1] + nxtRs[1]) % MOD;
			}
		} else {
			from = solve(cArr, cur + 1, end);
			rs = move(from, cArr[cur]);
		}
		return rs;
	}

	private static long[] move(long[] from, char sign) {
		long l1 = 0, l2 = 0;

		if (sign == 'N') {
			l1 = from[0];
			l2 = from[1] - 1;
		} else if (sign == 'S') {
			l1 = from[0];
			l2 = from[1] + 1;
		} else if (sign == 'E') {
			l1 = from[0] + 1;
			l2 = from[1];
		} else if (sign == 'W') {
			l1 = from[0] - 1;
			l2 = from[1];
		} else if (sign == 'X') {
			l1 = from[0] + 1;
			l2 = from[1] + 1;
		}

		if (l1 <= 0) {
			l1 += MOD;
		}
		if (l2 <= 0) {
			l2 += MOD;
		}
		return new long[] {l1 % MOD, l2 % MOD};
	}
}