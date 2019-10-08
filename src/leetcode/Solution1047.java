package leetcode;

public class Solution1047 {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            int size = sb.length();
            char c = S.charAt(i);
            if (size >= 1 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}