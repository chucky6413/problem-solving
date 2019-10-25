package leetcode;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mi = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[mi]) {
                mi = i;
            }
        }

        TreeNode node = new TreeNode(nums[mi]);
        node.left = buildTree(nums, left, mi - 1);
        node.right = buildTree(nums, mi + 1, right);
        return node;
    }
}