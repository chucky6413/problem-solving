package leetcode;/*
 * @problem https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * @author chucky6413
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution230 {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);
        count++;

        if (count == k) {
            result = root.val;
            return;
        }

        inorder(root.right, k);
    }
}