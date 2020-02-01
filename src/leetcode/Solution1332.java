package leetcode;

public class Solution1332 {
	public int removePalindromeSub(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		} else if (isPalindrome(s)) {
			return 1;
		} else {
			return 2;
		}
	}

	private boolean isPalindrome(String s) {
		int l = 0;
		int r = s.length() - 1;

		while (l <= r) {
			if (s.charAt(l++) != s.charAt(r--)) {
				return false;
			}
		}
		return true;
	}
}