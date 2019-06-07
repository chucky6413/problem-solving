package leetcode;

public class Solution342 {
    public boolean isPowerOfFour(int num) {
        int max4power = getMax4Power(num);

        if (num <= 0 || num > max4power || (max4power % num != 0)) return false;

        while (num > 1) {
            num >>= 2;
        }
        return num == 1;
    }

    private int getMax4Power(int n) {
        long v = 4;
        while (v < Integer.MAX_VALUE) {
            v *= 4;
        }
        return (int) (v / 4);
    }
}
