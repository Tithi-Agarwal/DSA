//3665. Twisted Mirror Path Count

class Solution {
    public int check(int[][] grid, int i, int j, boolean right, boolean down, int[][] dp)
    {
        if(i >= grid.length || j >= grid[0].length)
            return 0;
        if(i == grid.length - 1 && j == grid[0].length - 1)
            return 1;

        if(grid[i][j] == 1)
        {
            if(right)
                return check(grid, i + 1, j, false, true, dp);
            else
                return check(grid, i, j + 1, true, false, dp);
        }

        if(dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = (check(grid, i + 1, j, false, true, dp) + check(grid, i, j + 1, true, false, dp)) % (int)(1e9 + 7);

    }
    public int uniquePaths(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return check(grid, 0, 0, false, false, dp) % (int)(1e9 + 7);
    }
}
