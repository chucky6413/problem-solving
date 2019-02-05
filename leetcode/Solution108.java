public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(null, nums, 0, nums.length - 1);
    }

    private TreeNode makeTree(TreeNode node, int[] nums, int left, int right) {
        if (left > right) {
            return node;
        }
        int mid = (left + right) / 2;
        node = new TreeNode(nums[mid]);
        node.left = makeTree(node.left, nums, left, mid - 1);
        node.right = makeTree(node.right, nums, mid + 1, right);
        return node;
    }
}