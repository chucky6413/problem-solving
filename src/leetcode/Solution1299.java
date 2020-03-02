package leetcode;

public class Solution1299 {
	public int[] replaceElements(int[] arr) {
		int max = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			int prevMax = max;
			if (arr[i] > max) {
				max = arr[i];
			}
			arr[i] = prevMax;
		}
		return arr;
	}
}