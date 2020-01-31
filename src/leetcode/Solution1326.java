package leetcode;

public class Solution1326 {
	public int minTaps(int n, int[] ranges) {
		int[] interval = new int[n + 1];

		for (int i = 0; i < ranges.length; i++) {
			int left = Math.max(i - ranges[i], 0);
			int right = Math.min(i + ranges[i], n);
			interval[left] = Math.max(right, interval[left]);
		}

		int rs = 1;
		int left = 0;
		int right = 0;
		int flag = 0;
		while (left <= right) {
			for (int i = left; i <= right; i++) {
				flag = Math.max(interval[i], flag);
			}
			if (flag == n) {
				return rs;
			} else {
				left = right + 1;
				right = flag;
				rs++;
			}
		}

		return -1;
	}
}