package codejam.kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2019C_2 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	private static final StringBuilder rs = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			rs.append(String.format("Case #%d: ", i))
				.append(solve())
				.append(NEW_LINE);
		}
		System.out.println(rs.toString());
	}

	private static int solve() throws IOException {
		String[] input = br.readLine().split(SPACE);
		int r = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);
		int limit = Integer.parseInt(input[2]);

		int[][] v = new int[r][c];
		for (int i = 0; i < r; i++) {
			input = br.readLine().split(SPACE);
			for (int j = 0; j < c; j++) {
				v[i][j] = Integer.parseInt(input[j]);
			}
		}

		int[][] subRec = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = c - 1; j >= 0; j--) {
				if (j == c - 1) {
					subRec[i][j] = 1;
					continue;
				}

				int min = 1001;
				int max = -1;
				int cnt = 0;
				for (int k = j; k < c; k++) {
					min = Math.min(v[i][k], min);
					max = Math.max(v[i][k], max);
					if (max - min <= limit) {
						cnt++;
					} else {
						break;
					}
				}
				subRec[i][j] = cnt;
			}
		}

		int res = -1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int min = 301;
				for (int k = i; k < r; k++) {
					min = Math.min(subRec[k][j], min);
					res = Math.max((min) * (k - i + 1), res);
				}
			}
		}
		return res;
	}
}