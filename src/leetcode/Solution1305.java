package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1305 {
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		setElementsByInorderTraversal(root1, q1);
		setElementsByInorderTraversal(root2, q2);

		List<Integer> res = new ArrayList<>();
		while (!q1.isEmpty() || !q2.isEmpty()) {
			if (q2.isEmpty() || !q1.isEmpty() && (q1.peek() < q2.peek())) {
				res.add(q1.poll());
			} else {
				res.add(q2.poll());
			}
		}

		return res;
	}

	private void setElementsByInorderTraversal(TreeNode root, Queue<Integer> q) {
		if (root == null) {
			return;
		}
		setElementsByInorderTraversal(root.left, q);
		q.offer(root.val);
		setElementsByInorderTraversal(root.right, q);
	}
}