public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        int p1 = S.length() - 1;
        int p2 = T.length() - 1;

        while (true) {
            if (p1 >= 0 && '#' == S.charAt(p1)) {
                p1 = getNextValidIndex(S, p1 - 1);
            }

            if (p2 >= 0 && '#' == T.charAt(p2)) {
                p2 = getNextValidIndex(T, p2 - 1);
            }

            if (p1 >= 0 && p2 >= 0) {
                if (S.charAt(p1--) != T.charAt(p2--)) {
                    return false;
                }
            } else {
                return p1 == -1 && p2 == -1;
            }
        }
    }

    private int getNextValidIndex(String s, int curIndex) {
        int backspaceCount = 1;
        while (curIndex >= 0 && ('#' == s.charAt(curIndex) || backspaceCount > 0)) {
            backspaceCount += ('#' == s.charAt(curIndex)) ? 1 : -1;
            curIndex--;
        }
        return curIndex;
    }
}