package leetcode;

public class Solution1108 {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder(address.length() + 6);
        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}