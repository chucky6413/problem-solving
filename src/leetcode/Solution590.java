package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution590 {
    private List<Integer> rs;

    public List<Integer> postorder(Node root) {
        if (rs == null) rs = new ArrayList<>();
        if (root == null) return rs;

        for (Node n : root.children) {
            postorder(n);
        }
        rs.add(root.val);
        return rs;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}