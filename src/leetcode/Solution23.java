package leetcode;

import java.util.PriorityQueue;

public class Solution23 {
    class Node implements Comparable<Node> {
        int index;
        int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }

        public int compareTo(Node n) {
            return val <= n.val ? -1 : 1;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(new Node(i, lists[i].val));
            }
        }

        ListNode rs = new ListNode(0);
        ListNode cur = rs;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            cur.next = new ListNode(node.val);
            cur = cur.next;

            lists[node.index] = lists[node.index].next;
            if (lists[node.index] != null) {
                pq.offer(new Node(node.index, lists[node.index].val));
            }
        }

        return rs.next;
    }
}