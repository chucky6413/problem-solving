package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean negative = false;
        // process to negative
        if (numerator < 0) {
            negative = !negative;
        }
        if (denominator < 0) {
            negative = !negative;
        }
        String sign = negative ? "-" : "";

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        long f = n / d;
        n %= d;

        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder(sign + f + ".");
        int index = sb.length();
        while (!map.containsKey(n)) {
            if (n == 0) {
                if (sb.lastIndexOf(".") == sb.length() - 1) {
                    if (f == 0) {
                        return f + "";
                    } else {
                        return sb.toString().replace(".", "");
                    }
                }
                return sb.toString();
            }

            map.put(n, index++);
            sb.append(10 * n / d);
            n = n * 10 % d;
        }

        sb.insert(map.get(n), "(");
        return sb.toString() + ")";
    }
}