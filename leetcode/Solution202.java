import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            int v = n;
            n = 0;

            while (v != 0) {
                int lastDigit = v % 10;
                n += (lastDigit * lastDigit);
                v /= 10;
            }

            if (!set.add(n)) {
                return false;
            }
        }

        return true;
    }
}