// 877. Stone Game


class Solution {
    public int check(int[] nums,int l,int r,int[][] dp)
    {
        if(l==r)
        return nums[l];

        if(dp[l][r]!=-1)
        return dp[l][r];

        dp[l][r]=Math.max(nums[l]-check(nums,l+1,r,dp),nums[r]-check(nums,l,r-1,dp));

        return dp[l][r];
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
        dp[i][i]=piles[i];

        for(int l=n-2;l>=0;l--)
        {
            for(int r=l+1;r<n;r++)
            {
                dp[l][r]=Math.max(piles[l]-dp[l+1][r],piles[r]-dp[l][r-1]);
            }
        }
        return dp[0][n-1]>0;
        //return check(piles,0,piles.length-1,dp)>0;
    }
}