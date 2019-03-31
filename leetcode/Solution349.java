import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums1) {
            set.add(n);
        }

        List<Integer> intersect = new ArrayList<>();
        for (int n : nums2) {
            if (set.contains(n)) {
                set.remove(n);
                intersect.add(n);
            }
        }

        int[] rs = new int[intersect.size()];
        int i = 0;
        for (int n : intersect) {
            rs[i] = intersect.get(i++);
        }

        return rs;
    }
}