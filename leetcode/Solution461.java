public class Solution461 {
    public int hammingDistance(int x, int y) {
        int hd = 0;
        int mask = 1;
        int xor = x ^ y;
        for (int i = 0; i < 32; i++) {
            if ((mask & xor) != 0) {
                hd++;
            }
            mask <<= 1;
        }
        return hd;
    }
}