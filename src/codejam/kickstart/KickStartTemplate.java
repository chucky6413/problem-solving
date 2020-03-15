package codejam.kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KickStartTemplate {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	private static final StringBuilder rs = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			rs.append(String.format("Case #%d: ", i))
				.append(solve())
				.append(NEW_LINE);
		}
		System.out.println(rs.toString());
	}

	private static int solve() {
		return 0;
	}
}