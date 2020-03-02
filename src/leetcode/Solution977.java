package leetcode;

public class Solution977 {
	public int[] sortedSquares(int[] A) {
		int[] rs = new int[A.length];
		int idx = A.length - 1;
		int left = 0;
		int right = A.length - 1;
		while (left <= right) {
			if (Math.abs(A[left]) > Math.abs(A[right])) {
				rs[idx--] = square(A[left++]);
			} else {
				rs[idx--] = square(A[right--]);
			}
		}
		return rs;
	}

	private int square(int val) {
		return val * val;
	}
}