//3310. Remove Methods From Project

import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
        adj.add(new ArrayList<Integer>());

        for(int i = 0; i < invocations.length; i++)
        {
            adj.get(invocations[i][0]).add(invocations[i][1]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(k);

        int[] sus = new int[n];
        Arrays.fill(sus,0);

        while(!q.isEmpty())
        {
            int start = q.poll();
            if(sus[start]!=1)
            {
                sus[start]=1;
                for(int it: adj.get(start))
                q.add(it);
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(sus[i] == 0)
            {
                for(int it: adj.get(i))
                {
                    if(sus[it]==1)
                    {
                        Arrays.fill(sus,0);
                        break;
                    }
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            if(sus[i] == 0)
                ans.add(i);
        }

        return ans;

    }
}