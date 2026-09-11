//188. Best Time to Buy and Sell Stock IV
import java.util.*;

//Recursion
class Solution {
    public int check(int[] nums, int buy, int lim, int ind)
    {
        if(lim <= 0 || ind == nums.length)
            return 0;

        if(buy == 1)
        {
            return Math.max((-1 * nums[ind]) + check(nums, 0, lim, ind +1), check(nums, 1, lim, ind + 1));
        }
        else
        {
            return Math.max(nums[ind] + check(nums, 1, lim - 1, ind +1), check(nums, 0, lim, ind +1));
        }
    }
    public int maxProfit(int k, int[] prices) {
        return check(prices, 1, k, 0);
    }
}



//Memoization
class Solution2 {
    public int check(int[] nums, int buy, int lim, int ind, int[][][] dp)
    {
        if(lim <= 0 || ind == nums.length)
            return 0;

        if(dp[ind][buy][lim] != -1)
            return dp[ind][buy][lim];

        if(buy == 1)
        {
            return dp[ind][buy][lim] = Math.max((-1 * nums[ind]) + check(nums, 0, lim, ind +1, dp), check(nums, 1, lim, ind + 1, dp));
        }
        else
        {
            return dp[ind][buy][lim] = Math.max(nums[ind] + check(nums, 1, lim - 1, ind +1, dp), check(nums, 0, lim, ind + 1, dp));
        }
    }
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k + 1];
        for(int[][] mat: dp)
            for(int[] row: mat)
                Arrays.fill(row, -1);
        return check(prices, 1, k, 0, dp);
    }
}