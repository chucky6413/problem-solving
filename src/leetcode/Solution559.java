package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            while (size-- > 0) {
                Node n = q.poll();
                for (Node c : n.children) {
                    q.offer(c);
                }
            }
        }
        return depth;
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