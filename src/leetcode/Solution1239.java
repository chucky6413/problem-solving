package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1239 {
    public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : arr) {
            int bits = 0;
            boolean dup = false;
            for (char c : s.toCharArray()) {
                int b = 1 << (c - 'a');
                dup = dup || (bits & b) > 0;
                bits |= b;
            }
            if (dup) {
                continue;
            }
            for (int i = 0; i < dp.size(); i++) {
                if ((bits & dp.get(i)) > 0) {
                    continue;
                }
                dp.add(bits | dp.get(i));
                res = Math.max(res, Integer.bitCount(bits | dp.get(i)));
            }
        }
        return res;
    }
}