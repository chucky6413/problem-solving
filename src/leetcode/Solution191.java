package leetcode;

public class Solution191 {
    public int hammingWeight(int n) {
        int bc = 0;
        for (int i = 0; i < 32; i++) {
            bc += n % 2;
            n >>= 1;
        }
        return Math.abs(bc);
    }
}