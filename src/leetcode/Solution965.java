package leetcode;

public class Solution965 {
	private int univalue = -1;

	public boolean isUnivalTree(TreeNode root) {
		if (univalue == -1) {
			univalue = root.val;
		} else if (root == null) {
			return true;
		} else if (root.val != univalue) {
			return false;
		}
		return isUnivalTree(root.left) && isUnivalTree(root.right);
	}
}