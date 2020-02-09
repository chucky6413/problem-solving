package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution1346 {
	public boolean checkIfExist(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int num : arr) {
			if (set.contains(num * 2)
				|| num % 2 == 0 && set.contains(num / 2)) {
				return true;
			}
			set.add(num);
		}
		return false;
	}
}