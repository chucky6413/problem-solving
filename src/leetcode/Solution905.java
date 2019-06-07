package leetcode;

public class Solution905 {
    public int[] sortArrayByParity(int[] A) {
        int ei = 0, oi = A.length - 1;
        while (ei < oi) {
            while (ei < oi && A[ei] % 2 == 0) {
                ei++;
            }
            while (ei < oi && A[oi] % 2 == 1) {
                oi--;
            }
            if (ei < oi) {
                int temp = A[ei];
                A[ei] = A[oi];
                A[oi] = temp;
            }
        }
        return A;
    }
}