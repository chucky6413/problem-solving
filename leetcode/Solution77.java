import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rs = new ArrayList<>();
        LinkedList<Integer> subList = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            subList.add(i);
            recur(rs, i + 1, n, k, subList);
            subList.removeLast();
        }

        return rs;
    }

    public void recur(List<List<Integer>> rs, int cur, int n, int k, LinkedList<Integer> subList) {
        if (subList.size() == k) {
            rs.add(new LinkedList<>(subList));
            return;
        }

        for (int i = cur; i <= n; i++) {
            subList.add(i);
            recur(rs, i + 1, n, k, subList);
            subList.removeLast();
        }
    }
}