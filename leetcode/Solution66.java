public class Solution66 {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];

        int upper = 1;
        for(int i = digits.length - 1 ; i >= 0 ; i --) {
            int val = digits[i] + upper;
            upper = val / 10;
            res[i + 1] = digits[i] = val % 10;
        }

        if (upper != 0) {
            res[0] = 1;
        } else {
            res = digits;
        }

        return res;
    }
}
