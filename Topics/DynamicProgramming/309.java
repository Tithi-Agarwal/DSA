//309. Best Time to Buy and Sell Stock with Cooldown
import java.util.*;

//Recursion
class Solution {
    public int check(int[] nums, int ind, int buy)
    {
        if(ind >= nums.length)
            return 0;
        
        if(buy == 1)
        {
            return Math.max((-1 * nums[ind]) + check(nums, ind + 1, 0), check(nums, ind + 1, 1));
        }
        else
        {
            return Math.max(nums[ind] + check(nums, ind + 2, 1), check(nums, ind + 1, 0));
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
        if(ind >= nums.length)
            return 0;

        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        
        if(buy == 1)
        {
            return dp[ind][buy] = Math.max((-1 * nums[ind]) + check(nums, ind + 1, 0, dp), check(nums, ind + 1, 1, dp));
        }
        else
        {
            return dp[ind][buy] = Math.max(nums[ind] + check(nums, ind + 2, 1, dp), check(nums, ind + 1, 0, dp));
        }
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return check(prices, 0, 1, dp);
    }
}
