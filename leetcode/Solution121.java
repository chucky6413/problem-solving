public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int res = 0;
        int minValue = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minValue) {
                minValue = price;
            } else if (price - minValue > res) {
                res = price - minValue;
            }
        }

        return res;
    }
}