package leetcode;

public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];

        for (int num : arr1) {
            counts[num]++;
        }

        int[] res = new int[arr1.length];
        int idx = 0;
        for (int num : arr2) {
            while (counts[num]-- > 0) {
                res[idx++] = num;
            }
        }

        for (int num = 0; num < counts.length; num++) {
            while (counts[num]-- > 0) {
                res[idx++] = num;
            }
        }

        return res;
    }
}