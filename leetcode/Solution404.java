public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rs = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            rs += root.left.val;
        }
        return rs + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}