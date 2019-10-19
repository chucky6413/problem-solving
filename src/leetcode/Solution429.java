package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rs = new ArrayList<>();
        if (root == null) return rs;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int loop = q.size();
            List<Integer> subList = new ArrayList<>();
            while (loop-- > 0) {
                Node n = q.poll();
                subList.add(n.val);
                for (Node c : n.children) {
                    q.offer(c);
                }
            }
            rs.add(subList);
        }
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