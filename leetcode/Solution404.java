public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return traverse(root);
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int rs = 0;
        if (node.left != null && node.left.left == null && node.left.right == null) {
            rs += node.left.val;
        }
        return rs + traverse(node.left) + traverse(node.right);
    }
}