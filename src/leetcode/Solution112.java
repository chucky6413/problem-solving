package leetcode;

public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode node, int curSum, int target) {
        if (node == null) {
            return false;
        } else if (node.left == null && node.right == null) {
            return node.val + curSum == target ? true : false;
        }

        return dfs(node.left, node.val + curSum, target) || dfs(node.right, node.val + curSum, target);
    }
}