public class Solution326 {
    public boolean isPowerOfThree(int n) {
        int max3power = getMax3Power(n);

        if (n <= 0 || n > max3power) return false;
        return max3power % n == 0;
    }

    private int getMax3Power(int n) {
        long v = 3;
        while (v < Integer.MAX_VALUE) {
            v *= 3;
        }
        return (int) (v / 3);
    }
}