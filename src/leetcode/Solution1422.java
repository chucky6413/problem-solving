package leetcode;

public class Solution1422 {
	public int maxScore(String s) {
		int oneCnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				oneCnt++;
			}
		}

		int max = 0;
		int zeroCnt = 0;
		for (int j = 0; j < s.length() - 1; j++) {
			if (s.charAt(j) == '0') {
				zeroCnt++;
			} else {
				oneCnt--;
			}
			max = Math.max(zeroCnt + oneCnt, max);
		}
		return max;
	}
}