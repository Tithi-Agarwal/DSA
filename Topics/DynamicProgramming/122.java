//122. Best Time to Buy and Sell Stock II
import java.util.*;

//Recursion
class Solution {
    public int check(int[] nums, int ind, int buy)
    {
        if(ind == nums.length)
            return 0;


        if(buy == 1)
        {
            //take or not take
            return Math.max((nums[ind] * -1) + check(nums, ind + 1, 0), check(nums, ind + 1, 1));
        }
        else
        {
            //sell or not sell
            return Math.max(nums[ind] + check(nums, ind + 1, 1), check(nums, ind + 1, 0));
        }
    }
    public int maxProfit(int[] prices) {
        return check(prices, 0, 1);
    }
}



//Memoization
class Solution2 {
    public int check(int[] nums, int ind, int buy, int[][] dp)
    {
        if(ind == nums.length)
            return 0;

        if(dp[ind][buy] != -1)
            return dp[ind][buy];

        if(buy == 1)
        {
            //take or not take
            return dp[ind][buy] = Math.max((nums[ind] * -1) + check(nums, ind + 1, 0, dp), check(nums, ind + 1, 1, dp));
        }
        else
        {
            //sell or not sell
            return dp[ind][buy] = Math.max(nums[ind] + check(nums, ind + 1, 1, dp), check(nums, ind + 1, 0, dp));
        }
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return check(prices, 0, 1, dp);
    }
}



//Tabulation
class Solution3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];
        for(int[] row: dp)
            Arrays.fill(row, -1);

        //Base case
        dp[n][0] = 0;
        dp[n][1] = 0;

        //copy recursion
        for(int i = n-1; i >=0; i--)
        {
            dp[i][0] = Math.max(prices[i] + dp[i+1][1], dp[i+1][0]);
            dp[i][1] = Math.max((prices[i] * -1) + dp[i + 1][0], dp[i + 1][1]);
        }

        //return wt u call
        return dp[0][1];
    }
}



//Space Optimization
class Solution4 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int nextBuy = 0, nextSell = 0, currSell = 0, currBuy = 0;

        //copy recursion
        for(int i = n-1; i >=0; i--)
        {
            currSell = Math.max(prices[i] + nextBuy, nextSell);
            currBuy = Math.max((prices[i] * -1) + nextSell, nextBuy);
            nextBuy = currBuy;
            nextSell = currSell;
        }

        //return wt u call
        return currBuy;
    }
}