//3619. Count Islands With Total Value Divisible by K

class Solution {
    public long check(int[][] grid, int[][] vis, int r, int c)
    {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || vis[r][c] != -1)
            return 0;

        vis[r][c] = 1;
        
        long left = check(grid, vis, r, c - 1);
        long right = check(grid, vis, r, c + 1);
        long up = check(grid, vis, r - 1, c);
        long down = check(grid, vis, r + 1, c);
        return grid[r][c] + left + right + up + down;
    }
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int vis[][] = new int[m][n];
        for(int row[]: vis)
            Arrays.fill(row, -1);
        int ans = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] != 0 && vis[i][j] == -1)
                {
                    long val = check(grid, vis, i, j);
                    System.out.println(i+" "+j+" "+val);
                    if( val != 0 && val % k == 0)
                        ans++;
                }
            }
        }
        return ans;
    }
}
