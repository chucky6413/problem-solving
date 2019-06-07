package leetcode;

import java.util.*;

public class Solution524 {
    public String findLongestWord(String s, List<String> d) {
        String rs = "";

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }

        for (String word : d) {
            if (isPossible(map, word) && (word.length() > rs.length() || (word.length() == rs.length() && word.compareTo(rs) < 0))) {
                rs = word;
            }
        }

        return rs;
    }

    private boolean isPossible(Map<Character, List<Integer>> map, String word) {
        int cur = -1;
        int matCount = 0;

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (map.containsKey(c)) {
                for (Integer v : map.get(c)) {
                    if (v > cur) {
                        cur = v;
                        matCount++;
                        break;
                    }
                }
            }
        }

        return matCount == word.length();
    }
}