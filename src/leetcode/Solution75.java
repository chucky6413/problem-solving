package leetcode;

public class Solution75 {
    public void sortColors(int[] nums) {
        int redIdx = 0;
        int blueIdx = nums.length - 1;

        int index = 0;
        while (index <= blueIdx) {
            if (nums[index] == 0) {
                swap(nums, index, redIdx);
                redIdx++;
            } else if (nums[index] == 2) {
                swap(nums, index, blueIdx);
                blueIdx--;
                continue;
            }
            index++;
        }
    }

    private void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}