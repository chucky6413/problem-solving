package leetcode;

public class Solution1323 {
	public int maximum69Number(int num) {
		int n = 10000;
		while (n > 1) {
			int r = num % n;
			int d = r / (n / 10);
			if (d == 6) {
				num += 3 * (n / 10);
				return num;
			}
			n /= 10;
		}
		return num;
	}
}