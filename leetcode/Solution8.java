public class Solution8 {
    public int myAtoi(String str) {
        int start = 0;

        if (str.isEmpty()) {
            return 0;
        }

        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }

        int sign = 1;
        if (start < str.length() && (str.charAt(start) == '+' || str.charAt(start) == '-')) {
            sign = str.charAt(start++) == '+' ? 1 : -1;
        }

        int result = 0;
        while (start < str.length()) {
            int digit = str.charAt(start) - '0';

            if (digit < 0 || digit > 9) {
                break;
            }

            if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            start++;
        }

        return sign * result;
    }
}