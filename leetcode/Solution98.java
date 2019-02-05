import java.util.HashMap;
import java.util.Map;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        Map<String, Long> holder = new HashMap<>();
        holder.put("lastValue", Long.MIN_VALUE);
        return preorder(root, holder);
    }

    private boolean preorder(TreeNode node, Map<String, Long> holder) {
        if (node == null) {
            return true;
        }
        return preorder(node.left, holder) && helper(node, holder) && preorder(node.right, holder);
    }

    private boolean helper(TreeNode node, Map<String, Long> holder) {
        if (node.val <= holder.get("lastValue")) {
            return false;
        }
        holder.put("lastValue", (long) node.val);
        return true;
    }
}