import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution155 {
    class MinStack {
        List<Integer> list;
        Queue<Integer> minHeap;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new ArrayList<>();
            minHeap = new PriorityQueue<>();
        }

        public void push(int x) {
            list.add(x);
            minHeap.offer(x);
        }

        public void pop() {
            if (list.size() == 0) {
                return;
            }
            int v = list.remove(list.size() - 1);
            minHeap.remove(v);
        }

        public int top() {
            if (list.size() == 0) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

        public int getMin() {
            if (list.size() == 0) {
                return -1;
            }
            return minHeap.peek();
        }
    }
}