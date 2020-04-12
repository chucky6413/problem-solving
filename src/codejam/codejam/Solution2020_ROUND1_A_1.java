package codejam.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution2020_ROUND1_A_1 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			String[] p = new String[n];
			for (int j = 0; j < n; j++) {
				p[j] = sc.next();
			}

			rs.append(String.format("Case #%d: ", i))
				.append(solve(p))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static String solve(String[] p) {
		Set<String> prefixes = new HashSet<>();
		Set<String> middleWords = new HashSet<>();
		Set<String> suffixes = new HashSet<>();

		for (String s : p) {
			int firstAst = s.indexOf('*');
			int lastAst = s.lastIndexOf('*');

			prefixes.add(s.substring(0, firstAst));
			if (firstAst < lastAst) {
				String word = s.substring(firstAst + 1, lastAst).replaceAll("[*]", "");
				middleWords.add(word);
			}
			suffixes.add(s.substring(lastAst + 1));
		}

		String longestPrefix = "";
		String longestSuffix = "";
		for (String prefix : prefixes) {
			longestPrefix = prefix.length() > longestPrefix.length() ? prefix : longestPrefix;
		}
		for (String suffix : suffixes) {
			longestSuffix = suffix.length() > longestSuffix.length() ? suffix : longestSuffix;
		}

		if (startsWithAll(longestPrefix, prefixes) && endsWithAll(longestSuffix, suffixes)) {
			StringBuilder rs = new StringBuilder(longestPrefix);
			for (String word : middleWords) {
				rs.append(word);
			}
			rs.append(longestSuffix);
			return rs.toString();
		} else {
			return "*";
		}
	}

	private static boolean startsWithAll(String prefix, Set<String> targets) {
		for (String target : targets) {
			if (!prefix.startsWith(target)) {
				return false;
			}
		}
		return true;
	}

	private static boolean endsWithAll(String suffix, Set<String> targets) {
		for (String target : targets) {
			if (!suffix.endsWith(target)) {
				return false;
			}
		}
		return true;
	}
}