/*
 * @problem https://leetcode.com/problems/power-of-two/description/
 * @author chucky6413
 */

public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        if ((n % 2) != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }
}