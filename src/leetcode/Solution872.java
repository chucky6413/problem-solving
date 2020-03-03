package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution872 {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> leaves1 = getLeaves(root1);
		List<Integer> leaves2 = getLeaves(root2);

		if (leaves1.size() != leaves2.size()) {
			return false;
		}
		for (int i = 0; i < leaves1.size(); i++) {
			if (!Objects.equals(leaves1.get(i), leaves2.get(i))) {
				return false;
			}
		}
		return true;
	}

	private List<Integer> getLeaves(TreeNode root) {
		List<Integer> leaves = new ArrayList<>();
		traversalAndSetLeaves(root, leaves);
		return leaves;
	}

	private void traversalAndSetLeaves(TreeNode root, List<Integer> leaves) {
		if (root.left == null && root.right == null) {
			leaves.add(root.val);
			return;
		}
		if (root.left != null) {
			traversalAndSetLeaves(root.left, leaves);
		}
		if (root.right != null) {
			traversalAndSetLeaves(root.right, leaves);
		}
	}
}