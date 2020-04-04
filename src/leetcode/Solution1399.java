package leetcode;

public class Solution1399 {
	public int countLargestGroup(int n) {
		int[] cnt = new int[37];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			char[] c = String.valueOf(i).toCharArray();
			int sum = 0;
			for (char d : c) {
				sum += d - '0';
			}
			cnt[sum]++;
			max = Math.max(cnt[sum], max);
		}

		int rs = 0;
		for (int i = 0; i < 37; i++) {
			if (max == cnt[i]) {
				rs++;
			}
		}
		return rs;
	}
}