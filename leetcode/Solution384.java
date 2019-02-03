public class Solution384 {
    class Solution {
        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] sfar = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int r = (int)(Math.random() * (i + 1));
                sfar[i] = sfar[r];
                sfar[r] = nums[i];
            }
            return sfar;
        }
    }
}