import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> rs = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return rs;
        }

        final List<String> lettersList = Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        backtrack(digits, 0, lettersList, new StringBuilder(), rs);
        return rs;
    }

    private void backtrack(String digits, int cur, List<String> lettersList, StringBuilder temp, List<String> rs) {
        if (temp.length() == digits.length()) {
            rs.add(temp.toString());
            return;
        }

        int digit = Integer.parseInt(digits.charAt(cur) + "") - 2;

        String letters = lettersList.get(digit);
        for (char c : letters.toCharArray()) {
            temp.append(c);
            backtrack(digits, cur + 1, lettersList, temp, rs);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}