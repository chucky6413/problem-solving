package leetcode;

public class Solution1375 {
	public int numTimesAllBlue(int[] light) {
		int right = 0;
		int rs = 0;
		for (int i = 0; i < light.length; i++) {
			right = Math.max(light[i], right);
			if (i + 1 == right) {
				rs++;
			}
		}
		return rs;
	}
}