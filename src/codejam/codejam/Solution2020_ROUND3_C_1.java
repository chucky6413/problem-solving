package codejam.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution2020_ROUND3_C_1 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			String M = sc.next();

			rs.append(String.format("Case #%d: ", i))
				.append(solve(X, Y, M))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static String solve(int x, int y, String m) {
		if (x == 0 && y == 0) {
			return "0";
		}

		int minute = 0;
		for (int i = 0; i < m.length(); i++) {
			char c = m.charAt(i);
			if (c == 'N') {
				y++;
			} else if (c == 'E') {
				x++;
			} else if (c == 'S') {
				y--;
			} else if (c == 'W') {
				x--;
			}
			minute++;

			if (Math.abs(x) + Math.abs(y) <= minute) {
				return String.valueOf(minute);
			}
		}
		return "IMPOSSIBLE";
	}
}