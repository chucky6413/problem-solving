package leetcode;

public class Solution1224 {
    public int maxEqualFreq(int[] nums) {
        int[] cnt = new int[1_000_001];
        int[] freq = new int[1_000_001];
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            // for update freq
            freq[cnt[num]] -= 1;
            // set new cnt, freq
            int c = ++cnt[num];
            freq[c] += 1;

            if (freq[c] * c == i && i < nums.length) {
                res = i + 1;
            }

            int remain = i - freq[c] * c;
            // freq 1 인 녀석이 하나 남았거나
            // 한 녀석의 1 원소를 지우면 남는 freq count가 동일하게 되거나
            // ex : 7,2,2,3,3
            if ((remain == 1 || remain == c + 1) && (freq[remain] == 1)) {
                res = i;
            }
        }
        return res;
    }
}