package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * better solution
 * https://leetcode.com/problems/cinema-seat-allocation/discuss/546451/Java-Straightforward-solution-(bitwise)
 */

public class Solution1386 {
	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		Arrays.sort(reservedSeats, Comparator.comparingInt(other -> other[0]));

		int rs = n * 2;
		int idx = 0;
		while (idx < reservedSeats.length) {
			int row = reservedSeats[idx][0];
			boolean[] empty = new boolean[11];
			Arrays.fill(empty, true);
			while (idx < reservedSeats.length && row == reservedSeats[idx][0]) {
				empty[reservedSeats[idx++][1]] = false;
			}

			int cnt = 2;
			if (empty[2] && empty[3] && empty[4] && empty[5]) {
				cnt--;
			}
			if (empty[6] && empty[7] && empty[8] && empty[9]) {
				cnt--;
			}
			if (cnt == 2 && empty[4] && empty[5] && empty[6] && empty[7]) {
				cnt--;
			}
			rs -= cnt;
		}
		return rs;
	}
}