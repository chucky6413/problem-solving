public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode lstn, TreeNode rstn) {
        if (lstn == null && rstn == null) {
            return true;
        } else if (lstn == null || rstn == null || lstn.val != rstn.val) {
            return false;
        }

        return dfs(lstn.left, rstn.right) && dfs(lstn.right, rstn.left);
    }
}