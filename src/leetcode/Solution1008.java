package leetcode;

public class Solution1008 {
	private int idx = 0;

	public TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder, Integer.MAX_VALUE);
	}

	private TreeNode bstFromPreorder(int[] preorder, int bound) {
		if (preorder.length == idx || preorder[idx] > bound) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[idx++]);
		root.left = bstFromPreorder(preorder, root.val);
		root.right = bstFromPreorder(preorder, bound);
		return root;
	}
}