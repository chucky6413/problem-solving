package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rs = new ArrayList<>();
        recur(rs, 1, n, k, new ArrayList<>());
        return rs;
    }

    public void recur(List<List<Integer>> rs, int cur, int n, int k, List<Integer> subList) {
        if (subList.size() == k) {
            rs.add(new ArrayList<>(subList));
            return;
        }

        for (int i = cur; i <= n; i++) {
            subList.add(i);
            recur(rs, i + 1, n, k, subList);
            subList.remove(subList.size() - 1);
        }
    }
}