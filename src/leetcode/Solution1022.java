package leetcode;

public class Solution1022 {
	public int sumRootToLeaf(TreeNode root) {
		return dfs(root, 0);
	}

	private int dfs(TreeNode node, int bits) {
		if (node == null) {
			return 0;
		}
		bits = (bits * 2) + node.val;
		return node.left == node.right ? bits : dfs(node.left, bits) + dfs(node.right, bits);
	}
}