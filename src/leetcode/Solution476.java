package leetcode;

public class Solution476 {
	public int findComplement(int num) {
		int rs = 0;
		int v = 1;
		while (num != 0) {
			rs += (num & 1) == 1 ? 0 : v;
			v *= 2;
			num >>= 1;
		}
		return rs;
	}
}