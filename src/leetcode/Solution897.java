package leetcode;

public class Solution897 {
	private TreeNode node;
	private TreeNode pointer;

	public TreeNode increasingBST(TreeNode root) {
		if (root == null) {
			return null;
		}
		increasingBST(root.left);
		setValueToRight(root.val);
		increasingBST(root.right);
		return node;
	}

	private void setValueToRight(int val) {
		if (node == null) {
			node = new TreeNode(val);
			pointer = node;
		} else {
			pointer.right = new TreeNode(val);
			pointer = pointer.right;
		}
	}
}