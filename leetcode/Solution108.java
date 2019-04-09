public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length - 1);
    }

    private TreeNode makeTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeTree(nums, left, mid - 1);
        node.right = makeTree(nums, mid + 1, right);
        return node;
    }
}