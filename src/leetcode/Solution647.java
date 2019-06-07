package leetcode;

public class Solution647 {
    public int countSubstrings( String s ) {
        int rs = 0;

        char[] c = s.toCharArray();
        for ( int i = 0; i < c.length; i++ ) {
            rs += getPalindCount( i - 1, i + 1, c ) + 1;
            rs += getPalindCount( i, i + 1, c );
        }

        return rs;
    }

    private int getPalindCount( int left, int right, char[] c ) {
        int count = 0;

        while ( (left >= 0 && right < c.length) && c[left] == c[right] ) {
            left--;
            right++;
            count++;
        }

        return count;
    }
}