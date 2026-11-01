//1254. Number of Closed Islands

class Solution {
    public boolean check(int r, int c, int[][] grid, int[][] vis)
    {
        if(grid[r][c] == 1 || vis[r][c] == 1)
            return true;
        if(r >= grid.length - 1 || c >= grid[0].length - 1 || r <= 0 || c <= 0)
            return false;

        vis[r][c] = 1;
        // int[] row = {-1, 0, +1, 0}; //left, up, right, down
        // int[] col = {0, -1, 0, +1};
        //     for(int j = 0; j < 4; j++)
        //     {
        //         int newr = r + row[j];
        //         int newc = c + col[j];
        //         if(!check(newr, newc, grid, vis))
        //             return false;

        //     }
        boolean a = check(r + 1, c, grid, vis);
        boolean b = check(r - 1, c, grid, vis);
        boolean cc = check(r, c + 1, grid, vis);
        boolean d = check(r, c - 1, grid, vis);
        return  a && b && cc && d;
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int row[]: vis)
            Arrays.fill(row, -1);
        int count = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
            {
                if(vis[i][j] == -1 && grid[i][j] == 0 && check(i, j, grid, vis))
                {
                    count++;
                }
            }
        return count;
    }
}
