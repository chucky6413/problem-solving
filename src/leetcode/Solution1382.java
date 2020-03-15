package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1382 {
	private List<Integer> sortedList = new ArrayList<>();

	public TreeNode balanceBST(TreeNode root) {
		inorder(root);
		return generateBTree(0, sortedList.size() - 1);
	}

	private TreeNode generateBTree(int left, int right) {
		int mid = (left + right) / 2;

		TreeNode node = new TreeNode(sortedList.get(mid));
		if (left < mid) {
			node.left = generateBTree(left, mid - 1);
		}
		if (mid < right) {
			node.right = generateBTree(mid + 1, right);
		}
		return node;
	}

	private void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		sortedList.add(node.val);
		inorder(node.right);
	}
}