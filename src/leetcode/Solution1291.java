package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1291 {
	private final char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

	public List<Integer> sequentialDigits(int l, int h) {
		List<Integer> res = new ArrayList<>();

		int len = 2;
		int st = 10;
		while (st < (int)1e9) {
			for (int from = 0; from <= digits.length - len; from++) {
				int seqd = Integer.parseInt(
					new String(Arrays.copyOfRange(digits, from, from + len))
				);

				if (l <= seqd && seqd <= h) {
					res.add(seqd);
				}
			}
			len++;
			st *= 10;
		}

		return res;
	}
}