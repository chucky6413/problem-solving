package leetcode;

public class Solution961 {
    public int repeatedNTimes(int[] A) {
        boolean[] exist = new boolean[10000];
        for (int i = 0; i < A.length; i++) {
            if (exist[A[i]]) {
                return A[i];
            }
            exist[A[i]] = true;
        }
        return -1;
    }
}