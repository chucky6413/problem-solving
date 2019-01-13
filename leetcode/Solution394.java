public class Solution394 {
    private int idx = 0;

    public String decodeString(String s) {
        return solve(s.toCharArray(), 1);
    }

    private String solve(char[] cArr, int rep) {
        String s = "";
        String nextRep = "";

        while (idx < cArr.length && cArr[idx] != ']') {
            char c = cArr[idx];

            if (Character.isDigit(c)) {
                nextRep += c;
            } else if (Character.isLetter(c)) {
                s += c;
            } else if (c == '[') {
                int nr = Integer.parseInt(nextRep);
                idx = idx + 1;
                String sub = solve(cArr, nr);
                nextRep = "";
                s += sub;
            }
            idx = idx + 1;
        }

        String rs = "";
        while (rep-- > 0) {
            rs += s;
        }

        return rs;
    }
}