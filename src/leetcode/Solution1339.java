package leetcode;

import java.util.Stack;

public class Solution1339 {
	public int maxProduct(TreeNode root) {
		long rs = 0;
		Stack<Long> stack = new Stack<>();
		long rootSum = makeSubTreeSum(root, stack);
		stack.pop();
		while (!stack.isEmpty()) {
			long sum = stack.pop();
			rs = Math.max(((rootSum - sum) * sum), rs);
		}
		return (int)(rs % (1e9 + 7));
	}

	private long makeSubTreeSum(TreeNode node, Stack<Long> stack) {
		if (node == null) {
			return 0;
		}
		long sum = node.val + makeSubTreeSum(node.left, stack) + makeSubTreeSum(node.right, stack);
		stack.push(sum);
		return sum;
	}
}