package codejam.kickstart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class KickStartTemplate {
	//	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) throws FileNotFoundException {
		final Scanner sc = new Scanner(
			new BufferedReader(new FileReader(new File(".").getAbsolutePath() + "/src/codejam/input.txt")));

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			rs.append(String.format("Case #%d: ", i))
				.append(solve())
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static int solve() {
		return 0;
	}
}