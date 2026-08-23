//3471. Find the Largest Almost Missing Integer

import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {

        int s = 0, e = k - 1, ans = -1;
        int[] flag = new int[51];
        Arrays.fill(flag, 0);

        int c = 1;

        while(e < nums.length)
        {
            for(int i =s; i <= e; i++)
            {
                if(flag[nums[i]] != c && flag[nums[i]] != 0)
                    flag[nums[i]] = -1;
                else
                    flag[nums[i]] = c;

            }

            s++;
            e++;
            c++;

        }

        for(int i = 0; i < flag.length; i++)
        {
            if(flag[i] != -1 && flag[i] != 0)
                ans = i;
        }

        

        return ans;
    }
}