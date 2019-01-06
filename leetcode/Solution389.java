import java.util.Arrays;

public class Solution389 {
    public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        int i = 0;
        for (; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                break;
            }
        }

        return tArr[i];
    }
}