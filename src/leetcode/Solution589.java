package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution589 {
	public List<Integer> preorder(Node root) {
		List<Integer> rs = new ArrayList<>();
		solve(root, rs);
		return rs;
	}

	private void solve(Node node, List<Integer> result) {
		if (node == null) {
			return;
		}
		result.add(node.val);
		for (Node c : node.children) {
			solve(c, result);
		}
	}

	private static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
}