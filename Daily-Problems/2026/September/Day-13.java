//835. Image Overlap
import java.util.*;

class Pair {
    int row, col;

    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

class Solution {

    public int check(ArrayList<Pair> path, int[][] mat, int r, int c)
    {
        int count = 0;

        if(r >= 0 && r < mat.length &&
           c >= 0 && c < mat[0].length &&
           mat[r][c] == 1)
        {
            count = 1;
        }

        for(int i = 0; i < path.size(); i++)
        {
            Pair ele = path.get(i);

            r = r + ele.row;
            c = c + ele.col;

            if(r >= mat.length || c >= mat[0].length ||
               r < 0 || c < 0)
                continue;

            if(mat[r][c] == 1)
                count++;
        }

        return count;
    }

    public int largestOverlap(int[][] img1, int[][] img2)
    {
        int n = img1.length;
        int m = img1[0].length;

        int c = 0;
        int prevr = 0;
        int prevc = 0;

        ArrayList<Pair> path = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(img2[i][j] == 1 && c == 0)
                {
                    prevr = i;
                    prevc = j;
                    c++;
                    continue;
                }

                if(img2[i][j] == 1 && c > 0)
                {
                    path.add(new Pair(i - prevr, j - prevc));

                    prevr = i;
                    prevc = j;
                }
            }
        }

        if(c == 0)
            return 0;

        int ans = 0;

        // First 1 of img2 can be outside img1
        for(int i = -n + 1; i < n; i++)
        {
            for(int j = -m + 1; j < m; j++)
            {
                ans = Math.max(ans, check(path, img1, i, j));
            }
        }

        return ans;
    }
}