/*
 * @problem https://leetcode.com/problems/single-number-iii/description/
 * @author chucky6413
 */

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int allXor = 0;
        for (int num : nums) {
            allXor ^= num;
        }

        int diffIndex = 0;
        for (int i = 0; i < 32; i++) {
            if ((allXor & (1 << i)) != 0) {
                diffIndex = i;
                break;
            }
        }

        int a = 0, b = 0;

        for (int num : nums) {
            if (((num >> diffIndex) & 1) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}