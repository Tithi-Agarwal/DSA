//1140. Stone Game II

import java.util.*;

class Solution {

    int[][][] dp;

    public int check(int[] piles, int ind, int lim, int flag) {

        if(ind == piles.length) {
            return 0;
        }

        if(dp[ind][lim][flag] != -1) {
            return dp[ind][lim][flag];
        }

        if(flag == 0) { // Alice
            int max = Integer.MIN_VALUE;
            int curr = 0;

            for(int i = 1; i <= lim && ind + i <= piles.length; i++) {

                curr += piles[ind + i - 1];

                int next = check(
                    piles,
                    ind + i,
                    Math.min(piles.length,
    2 * Math.max(lim / 2, i)),
                    1
                );

                max = Math.max(max, curr + next);
            }

            return dp[ind][lim][flag] = max;
        }

        else { // Bob
            int min = Integer.MAX_VALUE;

            for(int i = 1; i <= lim && ind + i <= piles.length; i++) {

                int next = check(
                    piles,
                    ind + i,
                    Math.min(piles.length,
    2 * Math.max(lim / 2, i)),
                    0
                );

                min = Math.min(min, next);
            }

            return dp[ind][lim][flag] = min;
        }
    }

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new int[n][n + 1][2];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return check(piles, 0, Math.min(n, 2), 0);
    }
}