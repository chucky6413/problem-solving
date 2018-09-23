public class Solution189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;

        k %= nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            nums[left] ^= nums[right];
            nums[right] ^= nums[left];
            nums[left] ^= nums[right];

            left++;
            right--;
        }
    }
}
