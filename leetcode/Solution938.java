public class Solution938 {
    public int rangeSumBST( TreeNode root, int L, int R ) {
        if ( root == null ) {
            return 0;
        }
        int ans = (root.val < L || root.val > R) ? 0 : root.val;
        return ans + rangeSumBST( root.left, L, R ) + rangeSumBST( root.right, L, R );
    }
}