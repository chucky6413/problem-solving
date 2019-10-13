package leetcode;

public class Solution1221 {
    public int balancedStringSplit(String s) {
        int rs = 0;
        int r = 0, l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') r++;
            else l++;

            if (r == l) rs++;
        }
        return rs;
    }
}