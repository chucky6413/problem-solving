public class Solution583 {
    public int minDistance(String word1, String word2) {
        int lcs[][] = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) lcs[i][j] = 0;
                else {
                    lcs[i][j] =
                            word1.charAt(i - 1) == word2.charAt(j - 1) ?
                                    1 + lcs[i - 1][j - 1]
                                    : Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        return ( word1.length() + word2.length() ) - ( lcs[word1.length()][word2.length()] * 2 );
    }
}