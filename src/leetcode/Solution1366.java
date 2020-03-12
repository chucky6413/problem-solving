package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1366 {
	public String rankTeams(String[] votes) {
		Map<Character, int[]> map = new HashMap<>();
		int len = votes[0].length();
		for (String vote : votes) {
			for (int i = 0; i < len; i++) {
				char c = vote.charAt(i);
				map.putIfAbsent(c, new int[len]);
				map.get(c)[i]++;
			}
		}

		List<Character> ranks = new ArrayList<>(map.keySet());
		ranks.sort((team1, team2) -> {
			for (int i = 0; i < len; i++) {
				if (map.get(team1)[i] != map.get(team2)[i]) {
					return map.get(team2)[i] - map.get(team1)[i];
				}
			}
			return team1 - team2;
		});

		StringBuilder rs = new StringBuilder();
		for (Character team : ranks) {
			rs.append(team);
		}
		return rs.toString();
	}
}