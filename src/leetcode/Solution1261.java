package leetcode;

public class Solution1261 {

    // implementation problem
    class FindElements {
        private TreeNode root;

        private static final int max = 2_097_150;
        private boolean[] exist = new boolean[max + 1];

        public FindElements(TreeNode root) {
            this.root = root;
            recover(root, 0);
        }

        private void recover(TreeNode node, int v) {
            if (node == null) {
                return;
            }
            node.val = v;
            exist[node.val] = true;
            recover(node.left, (v * 2) + 1);
            recover(node.right, (v * 2) + 2);
        }

        public boolean find(int target) {
            return exist[target];
        }
    }
}