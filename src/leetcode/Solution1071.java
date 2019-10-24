package leetcode;

public class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder(str2);
        while (sb.length() > 0) {
            if (isDivisible(str2, sb.toString()) && isDivisible(str1, sb.toString())) {
                return sb.toString();
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private boolean isDivisible(String target, String str) {
        int tLen = target.length();
        int sLen = str.length();
        if (tLen % sLen != 0) {
            return false;
        }

        for (int i = 0; i < tLen; i += sLen) {
            String subStr = target.substring(i, i + sLen);
            if (!str.equals(subStr)) {
                return false;
            }
        }
        return true;
    }
}