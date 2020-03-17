package leetcode;

public class Solution1009 {
	public int bitwiseComplement(int N) {
		int ones = 1;
		while (N > ones) {
			ones = ones * 2 + 1;
		}
		return ones - N;
	}
}