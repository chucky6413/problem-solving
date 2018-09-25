import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution784 {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(S);

        for (int i = 0; i < S.length(); i++) {
            if (!((S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')
                    || (S.charAt(i) >= 'a' && S.charAt(i) <= 'z'))) {
                continue;
            }

            int curListSize = queue.size();
            for (int j = 0; j < curListSize; j++) {
                char[] cArr = queue.poll().toCharArray();

                cArr[i] = Character.toLowerCase(cArr[i]);
                queue.add(String.valueOf(cArr));

                cArr[i] = Character.toUpperCase(cArr[i]);
                queue.add(String.valueOf(cArr));
            }
        }

        return new LinkedList<>(queue);
    }
}