//118. Pascal's Triangle
package Topics.Arrays;
import java.util.*;

class Solution {
    public List<Integer> getNthRow(int n)
    {
        int i,ans=1;
        List<Integer> row=new ArrayList<>();
        row.add(1);
        for(i=1;i<n;i++)
        {
            ans=ans*(n-i)/i;
            row.add(ans);
        }
        return row;
    }
    public List<List<Integer>> generate(int numRows) 
    {
        int i;
        List<List<Integer>> res=new ArrayList<>();
        for(i=1;i<=numRows;i++)
        {
            res.add(getNthRow(i));
        }
        return res;
        
        
    }
}