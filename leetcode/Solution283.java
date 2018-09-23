class Solution283 {
    public void moveZeroes(int[] nums) {
        int target = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[target] = nums[i];

                if (target++ < i) {
                    nums[i] = 0;
                }
            }
        }
    }
}