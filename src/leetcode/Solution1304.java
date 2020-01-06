package leetcode;

public class Solution1304 {
	public int[] sumZero(int n) {
		int[] res = new int[n];
		int idx = 0;
		for (int i = 0; i < n / 2; i++) {
			res[idx++] = i + 1;
			res[idx++] = -(i + 1);
		}
		if (n % 2 != 0) {
			res[n - 1] = 0;
		}
		return res;
	}
}