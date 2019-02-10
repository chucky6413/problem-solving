import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();

        int rs = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (set.contains(c)) {
                rs = Math.max(rs, queue.size());
                while (queue.peek() != c) {
                    set.remove(queue.poll());
                }
                queue.poll();
                queue.add(c);
            } else {
                set.add(c);
                queue.add(c);
            }
        }
        return Math.max(rs, queue.size());
    }
}