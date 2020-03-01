package leetcode;

public class Solution1342 {
	public int numberOfSteps(int num) {
		int rs = 0;
		while (num > 0) {
			num = (num % 2 == 0) ? (num / 2) : (num - 1);
			rs++;
		}
		return rs;
	}
}