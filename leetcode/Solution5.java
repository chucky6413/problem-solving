public class Solution5 {
    public String longestPalindrome(String s) {
        String rs = "";
        for (int i = 0; i < s.length(); i++) {
            rs = getLongestPalindromeWithStartIdx(s, i, i, rs);
            rs = getLongestPalindromeWithStartIdx(s, i, i + 1, rs);
        }
        return rs;
    }

    private String getLongestPalindromeWithStartIdx(String s, int left, int right, String longestPalindrome) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (longestPalindrome.length() < right - left + 1) {
                longestPalindrome = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
        return longestPalindrome;
    }
}