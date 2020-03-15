package leetcode;

public class Solution705 {
	class MyHashSet {
		class ListNode {
			int key;
			ListNode next;

			public ListNode(int key) {
				this.key = key;
			}
		}

		private ListNode[] nodes;
		private final int SIZE = 10000;

		/** Initialize your data structure here. */
		public MyHashSet() {
			nodes = new ListNode[SIZE];
		}

		public void add(int key) {
			int idx = idx(key);
			if (nodes[idx] == null) {
				nodes[idx] = new ListNode(-1);
			}
			ListNode prev = prevNode(key);
			if (prev.next == null) {
				prev.next = new ListNode(key);
			}
		}

		public void remove(int key) {
			if (nodes[idx(key)] == null) {
				return;
			}
			ListNode prev = prevNode(key);
			if (prev.next != null) {
				prev.next = prev.next.next;
			}
		}

		/** Returns true if this set contains the specified element */
		public boolean contains(int key) {
			if (nodes[idx(key)] == null) {
				return false;
			}
			ListNode prev = prevNode(key);
			return prev.next != null ? true : false;
		}

		private int idx(int key) {
			return Integer.hashCode(key) % SIZE;
		}

		private ListNode prevNode(int key) {
			int idx = idx(key);
			ListNode node = nodes[idx];
			ListNode prev = null;
			while (node != null && node.key != key) {
				prev = node;
				node = node.next;
			}
			return prev;
		}
	}
}