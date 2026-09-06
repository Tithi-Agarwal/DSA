//115. Distinct Subsequences

class Solution {
    public int check(int i, int j, String s, String t,int[][] dp)
    {
        if(j >= t.length())
        return 1;

        if(i >= s.length())
        return 0;

        if(dp[j][i] != -1)
        return dp[j][i];

        if(s.charAt(i) == t.charAt(j))
        {
            return dp[j][i] = check(i+1, j+1, s, t, dp) + check(i+1, j, s, t, dp);
        }
        else
        {
            return dp[j][i] = check(i+1, j, s, t, dp);
        }
    }
    public int numDistinct(String s, String t) {

        int n = t.length();
        int m = s.length();

        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 0; i <= s.length(); i++)
        dp[n][i] = 1;

        for(int i = 0; i < n; i++)
        dp[i][m] = 0;

        for(int i = n-1 ; i>=0; i--)
            for(int j = m-1; j >=0; j--)
            {
                if(s.charAt(j) == t.charAt(i))
                dp[i][j] = dp[i][j+1] + dp[i+1][j+1];
                else
                dp[i][j] = dp[i][j+1];
            }

        return dp[0][0];
    }
}