package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1353 {
	public int maxEvents(int[][] events) {
		Arrays.sort(events, Comparator.comparingInt(e -> e[0]));

		Queue<Integer> endDays = new PriorityQueue<>();
		int i = 0;
		int rs = 0;
		for (int day = 1; day <= 100000; day++) {
			while (!endDays.isEmpty() && endDays.peek() < day) {
				endDays.poll();
			}
			while (i < events.length && events[i][0] == day) {
				endDays.offer(events[i++][1]);
			}
			if (!endDays.isEmpty()) {
				endDays.poll();
				rs++;
			}
		}
		return rs;
	}
}