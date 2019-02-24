import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            if (!set.add(n)) {
                return false;
            }
            String s = String.valueOf(n);
            n = 0;
            for (char c : s.toCharArray()) {
                n += (c - '0') * (c - '0');
            }
        }
        return true;
    }
}