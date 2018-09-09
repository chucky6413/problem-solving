import java.util.ArrayList;
import java.util.List;

/*
 * @problem https://leetcode.com/problems/palindrome-partitioning/description/
 * @author chucky6413
 */

public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> palindromePartionList = new ArrayList<>();
        backtracking(s, 0, new ArrayList<>(), palindromePartionList);
        return palindromePartionList;
    }

    public void backtracking(String s, int begin, List<String> subList, List<List<String>> result) {
        if (begin >= s.length()) {
            result.add(new ArrayList<>(subList));
        }

        for (int i = begin; i < s.length(); i++) {
            String startSubStr = s.substring(begin, i + 1);

            if (isPalindrome(s, begin, i)) {
                subList.add(startSubStr);
                backtracking(s, i + 1, subList, result);
                subList.remove(subList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}