import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int[] range = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            range[index] = Math.max(range[index], i);
        }

        List<Integer> rs = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            end = Math.max(range[index], end);
            if (end == i) {
                int size = (i + 1) - start;
                rs.add(size);
                start += size;
            }
        }

        return rs;
    }
}