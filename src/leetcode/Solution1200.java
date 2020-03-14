package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1200 {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		List<List<Integer>> rs = new ArrayList<>();
		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			min = Math.min(arr[i + 1] - arr[i], min);
		}
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] == min) {
				rs.add(Arrays.asList(arr[i], arr[i + 1]));
			}
		}
		return rs;
	}
}