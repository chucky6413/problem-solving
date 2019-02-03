public class Solution268 {
    public int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}