import java.util.HashMap;
import java.util.Map;

public class Solution865 {
    class Solution {
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            Map<Integer, Depth> depthMap = new HashMap<>();

            dfs(depthMap, root);

            int ld = depthMap.get(root.val).left;
            int rd = depthMap.get(root.val).right;
            while (ld != rd) {
                if (ld > rd) {
                    root = root.left;
                } else {
                    root = root.right;
                }
                ld = depthMap.get(root.val).left;
                rd = depthMap.get(root.val).right;
            }

            return root;
        }

        private int dfs(Map<Integer, Depth> depthMap, TreeNode root) {
            if (root == null) {
                return 1;
            }

            Depth depth = new Depth();
            depth.left = dfs(depthMap, root.left);
            depth.right = dfs(depthMap, root.right);
            depthMap.put(root.val, depth);

            return Math.max(depth.left, depth.right) + 1;
        }

        class Depth {
            int left;
            int right;
        }
    }
}