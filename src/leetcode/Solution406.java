package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int[] pair : people) {
            result.add(pair[1], pair);
        }
        return result.toArray(new int[0][0]);
    }
}