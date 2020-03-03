package leetcode;

public class Solution922 {
	public int[] sortArrayByParityII(int[] A) {
		int[] rs = new int[A.length];
		int even = 0;
		int odd = 1;
		for (int e : A) {
			if (e % 2 == 0) {
				rs[even] = e;
				even += 2;
			} else {
				rs[odd] = e;
				odd += 2;
			}
		}
		return rs;
	}
}