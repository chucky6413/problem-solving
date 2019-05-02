public class Solution821 {
    public int[] shortestToChar( String S, char C ) {
        int len = S.length();
        int[] dist = new int[len];

        int flag = -10000;
        for ( int i = 0; i < len; i++ ) {
            if ( S.charAt( i ) == C ) {
                flag = i;
            }
            dist[i] = i - flag;
        }

        for ( int i = len - 1; i >= 0; i-- ) {
            if ( S.charAt( i ) == C ) {
                flag = i;
            }
            dist[i] = Math.min( dist[i], Math.abs( flag - i ) );
        }

        return dist;
    }
}