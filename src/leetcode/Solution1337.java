package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution1337 {
	public int[] kWeakestRows(int[][] mat, int k) {
		return IntStream.range(0, mat.length)
			.mapToObj(i -> new Row(i, mat[i]))
			.sorted()
			.limit(k)
			.mapToInt(Row::getId)
			.toArray();
	}

	static class Row implements Comparable<Row> {
		int id;
		long numberOfSoldiers;

		Row(int id, int[] row) {
			this.id = id;
			this.numberOfSoldiers = getSoldiersCnt(row);
		}

		private long getSoldiersCnt(int[] row) {
			return Arrays.stream(row)
				.filter(e -> e == 1)
				.count();
		}

		int getId() {
			return id;
		}

		@Override
		public int compareTo(Row other) {
			if (numberOfSoldiers == other.numberOfSoldiers) {
				return id - other.id;
			}
			return (int)(numberOfSoldiers - other.numberOfSoldiers);
		}
	}
}