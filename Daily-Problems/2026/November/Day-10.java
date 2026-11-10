//3693. Climbing Stairs II
import java.util.*;

class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        
        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--)
        {
            int one = Integer.MAX_VALUE;
            int two = Integer.MAX_VALUE;
            int three = Integer.MAX_VALUE;

            if(i + 1 <= n)
                one = costs[i] + 1 + dp[i + 1];

            if(i + 2 <= n)
                two = costs[i + 1] + 4 + dp[i + 2];

            if(i + 3 <= n)
                three = costs[i + 2] + 9 + dp[i + 3];

            dp[i] = Math.min(one, Math.min(two, three));
        }

        return dp[0];
    }
}