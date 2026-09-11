//714. Best Time to Buy and Sell Stock with Transaction Fee
import java.util.*;

//Recursion
class Solution {
    public int check(int[] nums, int ind, int buy, int fee)
    {
        if(ind == nums.length)
            return 0;

        if(buy == 1)
        {
            return Math.max((-1 * nums[ind]) + check(nums, ind + 1, 0, fee), check(nums, ind + 1, 1, fee));
        }
        else
        {
            return Math.max(nums[ind] - fee + check(nums, ind + 1, 1, fee), check(nums, ind + 1, 0, fee));
        }
    }
    public int maxProfit(int[] prices, int fee) {
       return check(prices, 0, 1, fee); 
    }
}




//Memoization
class Solution2 {
    public int check(int[] nums, int ind, int buy, int[][] dp, int fee)
    {
        if(ind >= nums.length)
            return 0;

        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        
        if(buy == 1)
        {
            return dp[ind][buy] = Math.max((-1 * nums[ind]) + check(nums, ind + 1, 0, dp, fee), check(nums, ind + 1, 1, dp, fee));
        }
        else
        {
            return dp[ind][buy] = Math.max(nums[ind] - fee + check(nums, ind + 1, 1, dp, fee), check(nums, ind + 1, 0, dp, fee));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int[] row: dp)
            Arrays.fill(row, -1);
       return check(prices, 0, 1, dp, fee); 
    }
}