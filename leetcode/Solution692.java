import java.util.*;

public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }

        Queue<Node> queue = new PriorityQueue<>();
        for (String key : map.keySet()) {
            queue.offer(new Node(key, map.get(key)));

            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> rs = new ArrayList<>();
        while (!queue.isEmpty()) {
            rs.add(queue.poll().word);
        }
        Collections.reverse(rs);
        return rs;
    }

    class Node implements Comparable<Node> {
        String word;
        Integer count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public int compareTo(Node other) {
            return this.count.equals(other.count) ? other.word.compareTo(this.word) : this.count - other.count;
        }
    }
}