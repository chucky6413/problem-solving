package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewelsSet = new HashSet<>();
        for (char c : J.toCharArray()) {
            jewelsSet.add(c);
        }

        int num = 0;
        for (char c : S.toCharArray()) {
            if (jewelsSet.contains(c)) {
                num++;
            }
        }

        return num;
    }
}