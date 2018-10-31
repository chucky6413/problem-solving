public class Solution513 {
    private int result = 0;
    private int maxDepth = -1;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        } else if (depth > maxDepth) {
            result = node.val;
            maxDepth = depth;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
