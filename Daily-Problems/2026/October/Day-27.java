//3963. Create Grid With Exactly One Path

class Solution {
    public String[] createGrid(int m, int n) {
        int grid[][] = new int[m][n];
        for(int[] row: grid)
            Arrays.fill(row, 1);
        for(int i = 0 ; i < n; i++)
            grid[0][i] = 0;
        for(int i = 0; i < m; i++)
            grid[i][n-1] = 0;
        String[] ans = new String[m];
        for(int i = 0; i < m; i++)
        {
            StringBuilder curr = new StringBuilder("");
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                    curr.append("#");
                else
                    curr.append(".");
            }
            ans[i] = curr.toString();
        }
        return ans;
            
    }
}
