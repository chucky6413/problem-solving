package codejam.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution2020_Q_2 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String s = sc.next();

			rs.append(String.format("Case #%d: ", t))
				.append(solve(s))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static String solve(String s) {
		char[] digits = s.toCharArray();
		int[] d = new int[digits.length + 2];
		d[0] = 0;
		d[d.length - 1] = 0;
		for (int i = 1; i < d.length - 1; i++) {
			d[i] = digits[i - 1] - '0';
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < d.length - 1; i++) {
			for (int j = 0; j < d[i] - d[i - 1]; j++) {
				sb.append("(");
			}
			sb.append(d[i]);
			for (int j = 0; j < d[i] - d[i + 1]; j++) {
				sb.append(")");
			}
		}

		return sb.toString();
	}
}