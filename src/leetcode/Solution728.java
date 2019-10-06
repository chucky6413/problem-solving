package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        while (left <= right) {
            if (isDivisible(left)) {
                result.add(left);
            }
            left++;
        }
        return result;
    }

    private boolean isDivisible(int num) {
        for (int n = num; n > 0; n /= 10) {
            if (n % 10 == 0 || num % (n % 10) != 0) {
                return false;
            }
        }
        return true;
    }
}