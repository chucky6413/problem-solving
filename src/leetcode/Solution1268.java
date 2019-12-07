package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1268 {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);

		List<List<String>> res = new ArrayList<>();
		for (int e = 1; e <= searchWord.length(); e++) {
			String prefix = searchWord.substring(0, e);

			List<String> matches = new ArrayList<>();
			for (String pd : products) {
				if (matches.size() < 3 &&
					pd.indexOf(prefix) == 0) {
					matches.add(pd);
				}
			}
			res.add(new ArrayList<>(matches));
		}
		return res;
	}
}