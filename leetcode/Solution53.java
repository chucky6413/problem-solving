public class Solution53 {
    public int maxSubArray(int[] nums) {
        int maxvalue = Integer.MIN_VALUE;
        int curvalue = 0;

        for (int i = 0; i < nums.length; i++) {
            curvalue = curvalue > 0 ? curvalue + nums[i] : nums[i];
            maxvalue = Math.max(curvalue, maxvalue);
        }

        return maxvalue;
    }
}