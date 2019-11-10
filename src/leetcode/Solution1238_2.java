package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1238_2 {
    public List<Integer> circularPermutation(int n, int start) {
        int[] gray = new int[1 << n];
        int p = 0;
        for (int i = 0; i < gray.length; i++) {
            gray[i] = i ^ (i >> 1);
            if (gray[i] == start) {
                p = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < gray.length; i++) {
            res.add(gray[(i + p) % gray.length]);
        }
        return res;
    }
}