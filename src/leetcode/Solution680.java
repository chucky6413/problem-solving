package leetcode;

public class Solution680 {
    private boolean chance = true;

    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (chance) {
                    chance = false;
                    return validPalindrome(s.substring(l, r))
                            || validPalindrome(s.substring(l + 1, r + 1));
                }
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}