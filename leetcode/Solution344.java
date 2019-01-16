public class Solution344 {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        reverse(c, 0, c.length - 1);
        return new String(c);
    }

    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            swap(c, start++, end--);
        }
    }

    private void swap(char[] c, int i, int j) {
        c[i] ^= c[j];
        c[j] ^= c[i];
        c[i] ^= c[j];
    }
}