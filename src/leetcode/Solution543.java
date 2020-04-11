package leetcode;

public class Solution543 {
	private int rs = 1;

	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return rs - 1;
	}

	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lDepth = depth(root.left);
		int rDepth = depth(root.right);
		rs = Math.max(lDepth + rDepth + 1, rs);
		return Math.max(lDepth, rDepth) + 1;
	}
}