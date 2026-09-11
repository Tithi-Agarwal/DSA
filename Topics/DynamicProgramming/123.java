//123. Best Time to Buy and Sell Stock III
import java.util.*;

//Recursion
class Solution {
    public int check(int[] nums, int buy, int ind, int count)
    {
        if(count == 2)
            return 0;
        
        if(ind == nums.length)
            return 0;
            
        if(buy == 1)
        {
            return Math.max((nums[ind] * -1) + check(nums, 0, ind + 1, count), check(nums, 1, ind + 1, count));
        }
        else
        {
            return Math.max(nums[ind] + check(nums, 1, ind + 1, count + 1), check(nums, 0, ind + 1, count));
        }
    }
    public int maxProfit(int[] prices) {
        return check(prices, 1, 0, 0);
    }
}



//Memoization
class Solution2 {
    public int check(int[] nums, int buy, int ind, int count, int[][][] dp)
    {
        if(count == 2)
            return 0;
        
        if(ind == nums.length)
            return 0;

        if(dp[ind][buy][count] != -1)
            return dp[ind][buy][count];

        if(buy == 1)
        {
            return dp[ind][buy][count] = Math.max((nums[ind] * -1) + check(nums, 0, ind + 1, count, dp), check(nums, 1, ind + 1, count, dp));
        }
        else
        {
            return dp[ind][buy][count] = Math.max(nums[ind] + check(nums, 1, ind + 1, count + 1, dp), check(nums, 0, ind + 1, count, dp));
        }
    }
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] mat: dp)
            for(int[] row: mat)
                Arrays.fill(row, -1);
        return check(prices, 1, 0, 0, dp);
    }
}



//Tabulation
class Solution3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        
        //Base cases
        for(int i = 0; i <= n; i++)
            for(int j = 0; j < 2; j++)
                for(int k = 0; k <3; k++)
                {
                    if(i == n || k == 2)
                        dp[i][j][k] = 0;
                }

        for(int i = n-1; i >= 0; i--)
            for(int j = 0; j < 2; j++)
                for(int k = 0; k < 2; k++)
                {
                    if(j == 1)
                    {
                        dp[i][j][k] = Math.max((prices[i] * -1) + dp[i + 1][0][k], dp[i + 1][1][k]);
                    }
                    else
                    {
                        dp[i][j][k] = Math.max(prices[i] + dp[i + 1][1][k + 1], dp[i + 1][0][k]);
                    }

                }


        return dp[0][1][0]; //check(prices, 1, 0, 0, dp);
    }
}