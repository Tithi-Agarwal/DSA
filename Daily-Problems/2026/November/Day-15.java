//1524. Number of Sub-arrays With Odd Sum

class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int even = 1, odd = 0;
        long ans = 0;
        int sum = 0;

        for (int x : arr) {
            sum = (sum + x) % 2;
            if (sum == 1) {
                ans = (ans + even) % MOD;
                odd++;
            } else {
                ans = (ans + odd) % MOD;
                even++;
            }
        }

        return (int) ans;
    }
}