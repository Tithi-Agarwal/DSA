//121. Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], sell = prices[0], gain = 0;
        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i] < buy)
            {
                buy = prices[i];
                sell = prices[i];
            }
            if(prices[i] > sell)
            {
                sell = prices[i];
            }
            gain = Math.max(gain, sell - buy);
        }
        return gain;
    }
}