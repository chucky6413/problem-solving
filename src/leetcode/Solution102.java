package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        return traversal(nodes, rs);
    }

    private List<List<Integer>> traversal(List<TreeNode> nodes, List<List<Integer>> rs) {
        if (nodes.size() == 0) {
            return rs;
        }

        List<Integer> levelRs = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();
        for (TreeNode t : nodes) {
            levelRs.add(t.val);
            if (t.left != null) {
                nextNodes.add(t.left);
            }
            if (t.right != null) {
                nextNodes.add(t.right);
            }
        }
        rs.add(levelRs);
        return traversal(nextNodes, rs);
    }
}