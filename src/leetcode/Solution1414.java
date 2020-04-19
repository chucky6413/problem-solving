package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1414 {
	public int findMinFibonacciNumbers(int k) {
		List<Integer> fibos = new ArrayList<>();
		fibos.add(1);
		fibos.add(1);
		int next = 2;
		while (next <= k) {
			fibos.add(next);
			int len = fibos.size();
			next = fibos.get(len - 1) + fibos.get(len - 2);
		}

		int cnt = 0;
		int idx = fibos.size() - 1;
		while (k != 0) {
			if (fibos.get(idx) <= k) {
				k -= fibos.get(idx);
				cnt++;
			} else {
				idx--;
			}
		}
		return cnt;
	}
}