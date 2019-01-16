/**
 * ref : https://leetcode.com/problems/reverse-integer/discuss/4060/My-accepted-15-lines-of-code-for-Java
 */

public class Solution7 {
    public int reverse(int x) {
        int rs = 0;
        while (x != 0) {
            int backNumber = x % 10;
            int newRs = (rs * 10) + backNumber;
            if (newRs / 10 != rs) {
                return 0;
            }
            rs = newRs;
            x /= 10;
        }
        return rs;
    }
}