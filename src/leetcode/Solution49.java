package leetcode;

import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            String v = Arrays.toString(cArr);

            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(s);
        }

        List<List<String>> rs = new ArrayList<>();
        for (List<String> sub : map.values()) {
            rs.add(sub);
        }
        return rs;
    }
}