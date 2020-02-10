package leetcode;

public class Solution1347 {
	public int minSteps(String s, String t) {
		int[] cntOfS = new int[27];
		int[] cntOfT = new int[27];

		for (int i = 0; i < s.length(); i++) {
			cntOfS[s.charAt(i) - 'a']++;
			cntOfT[t.charAt(i) - 'a']++;
		}

		int rs = 0;
		for (int i = 0; i < 27; i++) {
			rs += cntOfS[i] > cntOfT[i] ? cntOfS[i] - cntOfT[i] : 0;
		}
		return rs;
	}
}