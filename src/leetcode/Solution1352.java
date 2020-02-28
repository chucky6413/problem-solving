package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1352 {
	class ProductOfNumbers {
		private List<Integer> products;
		private int lastZeroPos;

		public ProductOfNumbers() {
			products = new ArrayList<>();
			products.add(1);
			lastZeroPos = -1;
		}

		public void add(int num) {
			if (num == 0) {
				lastZeroPos = products.size();
				products.add(1);
			} else {
				products.add(products.get(products.size() - 1) * num);
			}
		}

		public int getProduct(int k) {
			if (products.size() - k <= lastZeroPos) {
				return 0;
			} else {
				return products.get(products.size() - 1) / products.get(products.size() - k - 1);
			}
		}
	}
}