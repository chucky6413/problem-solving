package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution409 {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.add(s.charAt(i))) {
                set.remove(c);
                count += 2;
            }
        }

        if (!set.isEmpty()) {
            count++;
        }

        return count;
    }
}