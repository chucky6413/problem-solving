import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    public boolean isHappy(int n) {
        char[] nums;
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            nums = String.valueOf(n).toCharArray();
            n = 0;

            for (char c : nums) {
                int num = Integer.parseInt(c + "");
                n += (num * num);
            }

            if (!set.add(n)) {
                return false;
            }
        }

        return true;
    }
}