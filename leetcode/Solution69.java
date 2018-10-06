public class Solution69 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        while (left <= right) {
            long mid = (left + right) / 2;

            if ((mid * mid) > x) {
                right = (int) mid - 1;
            } else {
                if ((mid + 1) * (mid + 1) > x)
                    return (int) mid;
                left = (int) mid + 1;
            }
        }

        return -1;
    }
}