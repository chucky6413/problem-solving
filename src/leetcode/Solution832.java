package leetcode;

public class Solution832 {
	public int[][] flipAndInvertImage(int[][] A) {
		for (int[] a : A) {
			flip(a);
			invert(a);
		}
		return A;
	}

	private void flip(int[] a) {
		int left = 0;
		int right = a.length - 1;

		while (left < right) {
			int tmp = a[left];
			a[left] = a[right];
			a[right] = tmp;
			left++;
			right--;
		}
	}

	private void invert(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] == 1 ? 0 : 1;
		}
	}
}