import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {

            if (node == null) {
                node = stack.pop();
            }

            rs.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            node = node.left;
        }

        return rs;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}