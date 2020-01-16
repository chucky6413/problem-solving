package leetcode;

public class Solution1310 {
	public int[] xorQueries(int[] arr, int[][] queries) {
		for (int i = 1; i < arr.length; i++) {
			arr[i] ^= arr[i - 1];
		}

		int[] rs = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int start = queries[i][0];
			int end = queries[i][1];

			if (start == 0) {
				rs[i] = arr[end];
			} else {
				rs[i] = arr[end] ^ arr[start - 1];
			}
		}

		return rs;
	}
}