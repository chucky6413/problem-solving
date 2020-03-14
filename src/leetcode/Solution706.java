package leetcode;

public class Solution706 {
	class MyHashMap {
		class ListNode {
			int key, val;
			ListNode next;

			ListNode(int key, int val) {
				this.key = key;
				this.val = val;
			}
		}

		final ListNode[] nodes;

		public MyHashMap() {
			nodes = new ListNode[10000];
		}

		public void put(int key, int value) {
			int idx = idx(key);
			if (nodes[idx] == null) {
				nodes[idx] = new ListNode(-1, -1);
			}
			ListNode prev = findPrev(key);
			if (prev.next == null) {
				prev.next = new ListNode(key, value);
			} else {
				prev.next.val = value;
			}
		}

		public int get(int key) {
			int idx = idx(key);
			if (nodes[idx] == null) {
				return -1;
			}
			ListNode prev = findPrev(key);
			return prev.next == null ? -1 : prev.next.val;
		}

		public void remove(int key) {
			int idx = idx(key);
			if (nodes[idx] == null) {
				return;
			}
			ListNode prev = findPrev(key);
			if (prev.next == null) {
				return;
			}
			prev.next = prev.next.next;
		}

		private int idx(int key) {
			return key % nodes.length;
		}

		private ListNode findPrev(int key) {
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