package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution412 {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public List<String> fizzBuzz(int n) {
        List<String> rs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String s = "";
            if (i % 3 == 0) {
                s += FIZZ;
            }
            if (i % 5 == 0) {
                s += BUZZ;
            }
            if (s.equals("")) {
                s += Integer.toString(i);
            }
            rs.add(s);
        }
        return rs;
    }
}