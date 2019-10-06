package leetcode;

public class Solution1209 {
    public String removeDuplicates(String s, int k) {
        int idx = 0;
        while (idx < s.length()) {
            int dupCnt = 0;
            char c = s.charAt(idx);

            while (idx < s.length() && s.charAt(idx) == c && dupCnt < k) {
                idx++;
                dupCnt++;
            }

            if (dupCnt == k) {
                return removeDuplicates(s.substring(0, idx - k) + s.substring(idx), k);
            }
        }

        return s;
    }
}