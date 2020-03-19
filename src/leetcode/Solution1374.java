package leetcode;

import java.util.Arrays;

public class Solution1374 {
	public String generateTheString(int n) {
		char[] c1 = new char[n];
		Arrays.fill(c1, 'a');
		char[] c2 = new char[1];
		Arrays.fill(c2, 'b');

		if (n % 2 == 1) {
			return String.valueOf(c1);
		} else {
			return String.valueOf(c1, 0, n - 1) + String.valueOf(c2);
		}
	}
}