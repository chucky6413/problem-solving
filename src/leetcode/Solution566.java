package leetcode;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution566 {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int h = nums.length;
		int w = nums[0].length;
		if ((h * w) != (r * c)) {
			return nums;
		}

		int[] flat = Stream.of(nums)
			.flatMapToInt(IntStream::of)
			.toArray();
		int idx = 0;

		int[][] res = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				res[i][j] = flat[idx++];
			}
		}
		return res;
	}
}