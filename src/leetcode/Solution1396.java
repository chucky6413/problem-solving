package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1396 {
	class UndergroundSystem {
		private Map<Integer, CheckIn> checkIn = new HashMap<>();
		private Map<String, CheckOut> checkOut = new HashMap<>();

		private class CheckIn {
			String stationName;
			int time;

			public CheckIn(String stationName, int time) {
				this.stationName = stationName;
				this.time = time;
			}
		}

		private class CheckOut {
			String route;
			int time;
			int cnt;

			public CheckOut(String route, int time, int cnt) {
				this.route = route;
				this.time = time;
				this.cnt = cnt;
			}
		}

		public UndergroundSystem() {

		}

		public void checkIn(int id, String stationName, int t) {
			checkIn.put(id, new CheckIn(stationName, t));
		}

		public void checkOut(int id, String stationName, int t) {
			CheckIn in = checkIn.get(id);
			String route = in.stationName + ":" + stationName;
			CheckOut out = checkOut.get(route);
			if (out != null) {
				out.time += t - in.time;
				out.cnt++;
			} else {
				checkOut.put(route, new CheckOut(route, t - in.time, 1));
			}
		}

		public double getAverageTime(String startStation, String endStation) {
			CheckOut out = checkOut.get(startStation + ":" + endStation);
			return (double)out.time / out.cnt;
		}
	}
}