package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        makeList(list, root, 0);
        return list;
    }

    private void makeList(List<List<Integer>> list, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(0, new ArrayList<>());
        }
        makeList(list, node.left, level + 1);
        makeList(list, node.right, level + 1);
        list.get(list.size() - 1 - level).add(node.val);
    }
}