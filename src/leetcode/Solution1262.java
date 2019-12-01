package leetcode;

public class Solution1262 {
    public int maxSumDivThree(int[] nums) {
        int[] sum = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {
            int[] tmp = new int[3];
            for (int remainder = 0; remainder < 3; remainder++) {
                tmp[(num + remainder) % 3] = Math.max(sum[(num + remainder) % 3], sum[remainder] + num);
            }
            sum = tmp;
        }

        return sum[0];
    }
}