//1563. Stone Game V

import java.util.*;

class Solution {

    int[][] dp;
    int[] prefix;

    public int check(int[] nums, int s, int e) {

        if (e - s <= 1)
            return 0;

        if (dp[s][e] != -1)
            return dp[s][e];

        int total = prefix[e] - prefix[s];

        int sum = 0;
        int max = 0;

        for (int i = s; i < e - 1; i++) {

            sum += nums[i];

            int rightSum = total - sum;

            if (sum < rightSum) {

                max = Math.max(
                    max,
                    sum + check(nums, s, i + 1)
                );

            } 
            else if (sum > rightSum) {

                max = Math.max(
                    max,
                    rightSum + check(nums, i + 1, e)
                );

            } 
            else {

                max = Math.max(
                    max,
                    Math.max(
                        sum + check(nums, s, i + 1),
                        rightSum + check(nums, i + 1, e)
                    )
                );
            }
        }

        return dp[s][e] = max;
    }

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        dp = new int[n + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return check(stoneValue, 0, n);
    }
}