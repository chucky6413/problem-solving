package leetcode;

public class Solution845 {
    public int longestMountain(int[] A) {
        int up = 0;
        int down = 0;
        int rs = 0;
        for (int i = 1; i < A.length; i++) {
            if ((down > 0 && A[i - 1] <= A[i]) || A[i - 1] == A[i]) {
                up = down = 0;
            }

            if (A[i - 1] < A[i]) {
                up++;
            }

            if (up > 0 && A[i - 1] > A[i]) {
                down++;
                rs = Math.max(rs, up + down + 1);
            }
        }
        return rs;
    }
}