package leetcode;

public class Solution1325 {
	public TreeNode removeLeafNodes(TreeNode root, int target) {
		if (root == null) {
			return null;
		}
		root.left = removeLeafNodes(root.left, target);
		root.right = removeLeafNodes(root.right, target);
		return shouldBeDeleted(root, target) ? null : root;
	}

	private boolean shouldBeDeleted(TreeNode node, int target) {
		return node != null
			&& node.val == target
			&& (node.left == null && node.right == null);
	}
}