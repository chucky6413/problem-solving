/*
 * @problem https://leetcode.com/problems/add-digits/description/
 * @author chucky6413
 */

public class Solution258 {
    public int addDigits(int num) {
        return num != 0 && ( num % 9 == 0 ) ? 9 : num % 9;
    }
}