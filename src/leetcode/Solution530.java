package leetcode;

public class Solution530 {
    private int rs = Integer.MAX_VALUE;
    private int lastNum = -1;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return rs;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        check(node.val);
        inorder(node.right);
    }

    private void check(int v) {
        if (lastNum != -1 && v - lastNum < rs) {
            rs = v - lastNum;
        }
        lastNum = v;
    }
}
