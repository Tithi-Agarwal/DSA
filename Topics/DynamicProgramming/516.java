//516. Longest Palindromic Subsequence
package Topics.DynamicProgramming;

class Solution {
    public int f(int l,int r,String s,int[][] dp)
    {
        if(s.charAt(l)==s.charAt(r))
        return dp[l][r]=2+f(l+1,r-1,s,dp);

        return dp[l][r]=Math.max(f(l,r-1,s,dp),f(l+1,r,s,dp));
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
        dp[i][i]=1;


        for(int l=0;l<n;l++)
        for(int r=0;r<n;r++)
        if(l>r)
        dp[l][r]=0;

        for(int l=n-2;l>=0;l--)
        {
            for(int r=l+1;r<n;r++)
            {
                if(s.charAt(l)==s.charAt(r))
                     dp[l][r]=2+dp[l+1][r-1];
                else
                    dp[l][r]=Math.max(dp[l][r-1],dp[l+1][r]);
            }
        }



        return dp[0][n-1];
    }
}


