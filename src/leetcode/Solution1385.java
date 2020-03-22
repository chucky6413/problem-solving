package leetcode;

public class Solution1385 {
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int rs = arr1.length;
		for (int from : arr1) {
			for (int to : arr2) {
				if (Math.abs(from - to) <= d) {
					rs--;
					break;
				}
			}
		}
		return rs;
	}
}