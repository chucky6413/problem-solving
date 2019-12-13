package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1276 {
	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		List<Integer> res = new ArrayList<>();

		int totalJumbo = tomatoSlices / 2 - cheeseSlices;
		int totalSmall = cheeseSlices - totalJumbo;

		if (isValidBurger(totalJumbo, totalSmall) &&
			isUseAll(totalJumbo, totalSmall, tomatoSlices, cheeseSlices)) {
			res.add(totalJumbo);
			res.add(totalSmall);
		}
		return res;
	}

	private boolean isValidBurger(int jumbo, int small) {
		return jumbo >= 0 && small >= 0;
	}

	private boolean isUseAll(int jumbo, int small, int tomato, int cheese) {
		tomato -= (jumbo * 4) + (small * 2);
		cheese -= (jumbo + small);
		return tomato == 0 && cheese == 0;
	}
}