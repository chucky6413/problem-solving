package leetcode;

public class Solution985 {
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] rs = new int[queries.length];
		int evenSum = 0;
		for (int i = 0; i < A.length; i++) {
			evenSum += A[i] % 2 == 0 ? A[i] : 0;
		}

		for (int i = 0; i < queries.length; i++) {
			int idx = queries[i][1];
			int val = queries[i][0];
			if (A[idx] % 2 == 0) {
				A[idx] += val;
				evenSum += A[idx] % 2 == 0 ? val : -A[idx] + val;
			} else {
				A[idx] += val;
				evenSum += A[idx] % 2 == 0 ? A[idx] : 0;
			}
			rs[i] = evenSum;
		}
		return rs;
	}
}