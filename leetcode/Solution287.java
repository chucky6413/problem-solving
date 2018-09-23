public class Solution287 {
    public int findDuplicate(int[] nums) {
        int turtle = 0;
        int rabbit = 0;

        do {
            turtle = nums[turtle];
            rabbit = nums[nums[rabbit]];
        } while (turtle != rabbit);

        // find cycle starting point
        turtle = 0;
        while (turtle != rabbit) {
            turtle = nums[turtle];
            rabbit = nums[rabbit];
        }

        return turtle;
    }
}