package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1238 {
    public List<Integer> circularPermutation(int n, int start) {
        boolean[] visit = new boolean[1 << 16];
        List<Integer> res = new ArrayList<>();
        dfs(start, visit, res, n);
        return res;
    }

    private void dfs(int num, boolean[] visit, List<Integer> res, int n) {
        if (visit[num]) {
            return;
        }
        res.add(num);
        visit[num] = true;
        for (int i = 0; i < n; i++) {
            dfs(num ^ (1 << i), visit, res, n);
        }
        if (res.size() == Math.pow(2, n)) {
            return;
        }
        res.remove(res.size() - 1);
        visit[num] = false;
    }
}