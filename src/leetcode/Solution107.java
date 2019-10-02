package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        preorder(root, 0, result);
        return getReverseList(result);
    }

    private List<List<Integer>> getReverseList(List<List<Integer>> target) {
        List<List<Integer>> reverse = new ArrayList<>();

        int size = target.size();
        for (int i = 0; i < size; i++) {
            reverse.add(target.get(size - 1 - i));
        }
        return reverse;
    }

    private void preorder(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        if (result.size() <= depth) {
            result.add(new ArrayList<Integer>());
        }

        result.get(depth).add(node.val);
        preorder(node.left, depth + 1, result);
        preorder(node.right, depth + 1, result);
    }
}
