package leetcode;

public class Solution1079 {
    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for (char c : tiles.toCharArray()) {
            cnt[c - 'A']++;
        }
        return dfs(cnt);
    }

    private int dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                continue;
            }
            arr[i]--;
            sum += dfs(arr) + 1;
            arr[i]++;
        }
        return sum;
    }
}