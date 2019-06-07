package leetcode;

public class Solution38 {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            String temp = sb.toString();

            char c = temp.charAt(0);
            int count = 1;

            sb.delete(0, sb.length());
            for (int j = 1; j < temp.length(); j++) {
                char cr = temp.charAt(j);
                if (c == cr) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    c = cr;
                    count = 1;
                }
            }
            sb.append(count).append(c);
        }

        return sb.toString();
    }
}