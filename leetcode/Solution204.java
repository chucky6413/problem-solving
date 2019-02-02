public class Solution204 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];

        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < n; i ++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < n;j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}