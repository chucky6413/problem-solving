public class Solution709 {
    public String toLowerCase(String str) {
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if ('A' <= c[i] && c[i] <= 'Z') {
                c[i] = (char) ((int) c[i] + 32);
            }
        }
        return String.valueOf(c);
    }
}