//44. Wildcard Matching
package Topics.DynamicProgramming;
import java.util.*;

class Solution {
    
    public boolean check(String s, String p, int i, int j, int[][] dp) {

        // Both string and pattern finished
        if(i == s.length() && j == p.length())
            return true;

        // Pattern finished but string remains
        if(j == p.length())
            return false;

        // String finished
        if(i == s.length()) {
            while(j < p.length()) {
                if(p.charAt(j) != '*')
                    return false;
                j++;
            }
            return true;
        }

        if(dp[i][j] != -1)
            return dp[i][j] == 1;

        if(p.charAt(j) == '*') {

            boolean take = check(s, p, i + 1, j, dp);

            boolean notTake = check(s, p, i, j + 1, dp);

            return (dp[i][j] = (take || notTake) ? 1 : 0) == 1;
        }

        if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {

            return (dp[i][j] =
                check(s, p, i + 1, j + 1, dp) ? 1 : 0) == 1;
        }

        
        dp[i][j] = 0;
        return false; 
    }

    public boolean isMatch(String s, String p) {

        int[][] dp = new int[s.length()][p.length()];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return check(s, p, 0, 0, dp);
    }
}