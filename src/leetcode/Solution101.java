package leetcode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode lstn, TreeNode rstn) {
        if (lstn == null && rstn == null) {
            return true;
        } else if (lstn == null || rstn == null || lstn.val != rstn.val) {
            return false;
        }

        return isMirror(lstn.left, rstn.right) && isMirror(lstn.right, rstn.left);
    }
}