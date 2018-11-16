import java.util.PriorityQueue;

public class Solution414 {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            if (!pq.contains(num)) {
                pq.offer(num);

                if (pq.size() > 3) {
                    pq.poll();
                }
            }
        }

        if (pq.size() < 3) {
            while (pq.size() != 1) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}