package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1002 {
    public List<String> commonChars(String[] A) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, Integer.MAX_VALUE);
        for (String s : A) {
            int[] subCnt = new int[26];
            for (char c : s.toCharArray()) {
                subCnt[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                cnt[i] = Math.min(subCnt[i], cnt[i]);
            }
        }

        List<String> rs = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            while (cnt[c - 'a']-- > 0) {
                rs.add(c + "");
            }
        }
        return rs;
    }
}