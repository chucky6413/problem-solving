import java.util.*;

public class Solution451 {
    public String frequencySort(String s) {
        Map<Character, StringBuilder> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, new StringBuilder()).append(c));
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });

        for (Map.Entry<Character, StringBuilder> entry : map.entrySet()) {
            pq.add(entry.getValue().toString());
        }

        StringBuilder rs = new StringBuilder("");
        while (!pq.isEmpty()) {
            rs.append(pq.poll());
        }

        return rs.toString();
    }
}
