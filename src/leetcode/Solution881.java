package leetcode;

import java.util.Arrays;

public class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;

        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[right--] + people[left] <= limit) {
                left++;
            }
            res++;
        }

        return res;
    }
}