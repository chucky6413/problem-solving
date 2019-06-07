package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> ancListOfP = new ArrayList<>();
        List<Integer> ancListOfQ = new ArrayList<>();

        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        dfs(root, p.val, new ArrayList<>(), ancListOfP, nodeMap);
        dfs(root, q.val, new ArrayList<>(), ancListOfQ, nodeMap);

        int lca = ancListOfP.get(0);
        int minLength = Math.min(ancListOfP.size(), ancListOfQ.size());
        for (int i = 1; i < minLength; i++) {
            if ((int) ancListOfP.get(i) != (int) ancListOfQ.get(i)) {
                break;
            }
            lca = ancListOfP.get(i);
        }

        return nodeMap.get(lca);
    }

    private void dfs(TreeNode node, int target, List<Integer> subList, List<Integer> rs, Map<Integer, TreeNode> nodeMap) {
        if (node == null) {
            return;
        }

        nodeMap.put(node.val, node);
        subList.add(node.val);
        if (node.val == target) {
            rs.addAll(subList);
            return;
        }

        dfs(node.left, target, subList, rs, nodeMap);
        dfs(node.right, target, subList, rs, nodeMap);
        subList.remove(subList.size() - 1);
    }
}