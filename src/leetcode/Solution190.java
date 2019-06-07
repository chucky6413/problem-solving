package leetcode;

public class Solution190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int mask = 1;
        int rs = 0;
        for (int i = 0; i < 32; i++) {
            rs <<= 1;
            if ((mask & n) != 0) {
                rs++;
            }
            mask <<= 1;
        }
        return rs;
    }
}