package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> rs = new ArrayList<>();
        backtrack(rs, 0, 0, n, new char[n * 2]);
        return rs;
    }

    private void backtrack(List<String> rs, int open, int close, int pairs, char[] sub) {
        if (open + close == pairs * 2) {
            rs.add(new String(sub));
            return;
        }

        if (open < pairs) {
            sub[open + close] = '(';
            backtrack(rs, open + 1, close, pairs, sub);
        }

        if (close < open) {
            sub[open + close] = ')';
            backtrack(rs, open, close + 1, pairs, sub);
        }
    }
}