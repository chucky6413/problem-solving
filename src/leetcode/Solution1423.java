package leetcode;

public class Solution1423 {
	public int maxScore(int[] cardPoints, int k) {
		int len = cardPoints.length;
		int[] fSum = new int[len + 1];
		int[] bSum = new int[len + 1];
		for (int i = 1; i <= len; i++) {
			fSum[i] = fSum[i - 1] + cardPoints[i - 1];
			bSum[i] = bSum[i - 1] + cardPoints[len - i];
		}

		int max = 0;
		for (int i = 0; i <= k; i++) {
			int cur1 = fSum[i] + bSum[k - i];
			int cur2 = fSum[k - i] + bSum[i];
			max = Math.max(Math.max(cur1, cur2), max);
		}
		return max;
	}
}