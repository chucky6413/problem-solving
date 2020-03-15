package leetcode;

import java.util.Arrays;

public class Solution1381 {
	class CustomStack {
		private int size = 0;
		private int limit = 0;
		private int[] values;

		public CustomStack(int maxSize) {
			limit = maxSize;
			values = new int[limit];
			Arrays.fill(values, -1);
		}

		public void push(int x) {
			if (size < limit) {
				values[size++] = x;
			}
		}

		public int pop() {
			if (size > 0) {
				int val = values[size - 1];
				values[size - 1] = -1;
				size--;
				return val;
			} else {
				return -1;
			}
		}

		public void increment(int k, int val) {
			for (int i = 0; i < Math.min(k, limit); i++) {
				values[i] += val;
			}
		}
	}
}