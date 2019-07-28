package leetcode;

public class Solution520 {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;

        for (char c : word.toCharArray()) {
            if (isCapital(c)) {
                cnt++;
            }
        }

        return cnt == 0 || cnt == word.length() || (cnt == 1 && isCapital(word.charAt(0)));
    }

    private boolean isCapital(char c) {
        return 'A' <= c && c <= 'Z';
    }
}