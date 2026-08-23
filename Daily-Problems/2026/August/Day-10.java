//2996. Smallest Missing Integer Greater Than Sequential Prefix Sum

import java.util.*;
class Solution {
    public int missingInteger(int[] nums) {
        int end = nums.length - 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] - 1 == nums[i-1])
            continue;
            else
            {
                end = i - 1;
                break;
            }
        }
        int s = 0;
        for(int i = 0; i <= end; i++)
            s+= nums[i];
        //System.out.print(fs+ " " + end+" "+s);

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == s)
                s++;
        }

        return s;

    }
}