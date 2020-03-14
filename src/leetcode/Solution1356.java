package leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution1356 {
	public int[] sortByBits(int[] arr) {
		List<Integer> nums = IntStream.of(arr)
			.boxed()
			.collect(Collectors.toList());

		return nums.stream()
			.sorted((n1, n2) -> {
				int cnt1 = getOneBitsCnt(n1);
				int cnt2 = getOneBitsCnt(n2);
				if (cnt1 != cnt2) {
					return cnt1 - cnt2;
				}
				return n1 - n2;
			})
			.mapToInt(i -> i)
			.toArray();
	}

	private int getOneBitsCnt(int num) {
		int cnt = 0;
		while (num > 0) {
			cnt += num & 1;
			num >>= 1;
		}
		return cnt;
	}
}