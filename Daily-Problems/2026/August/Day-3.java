// 1406. Stone Game III

import java.util.*;

class Solution {
    public int check(int[] nums,int ind,int[] dp)
    {
        int n=nums.length;
        if(ind>=nums.length)
        {
            return 0;
        }

        if(dp[ind]!=-1)
            return dp[ind];
            
        int first=Integer.MIN_VALUE,sec=Integer.MIN_VALUE,third=Integer.MIN_VALUE;
        first=nums[ind]-check(nums,ind+1,dp);

        if(ind+1<n)
        sec=nums[ind]+nums[ind+1]-check(nums,ind+2,dp);

        if(ind+2<n)
        third=nums[ind]+nums[ind+1]+nums[ind+2]-check(nums,ind+3,dp);
        
        //System.out.println(first+" "+sec+" "+third);
        return dp[ind]=Math.max(first,Math.max(sec,third));
    }
    public String stoneGameIII(int[] stoneValue) {
        // int total=0;
        // for(int ele:stoneValue)
        // total+=ele;
        int dp[]=new int[stoneValue.length];
        Arrays.fill(dp,-1);
        int res=check(stoneValue,0,dp);
        if(res==0)
        return "Tie";
        else if(res>0)
        return "Alice";
        return "Bob";
    }
}