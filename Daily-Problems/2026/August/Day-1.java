//486. Predict the Winner

class Solution {
    public boolean check(int[] nums,int l,int r,int s1,int s2,int flag)
    {
        if(l>r)
        return s1>=s2;

        if(flag%2!=0)
        {
            return check(nums,l+1,r,s1+nums[l],s2,0) || check(nums,l,r-1,s1+nums[r],s2,0);
        }
        else
        {
            return check(nums,l+1,r,s1,s2+nums[l],1) && check(nums,l,r-1,s1,s2+nums[r],1);
        }

    }
    public boolean predictTheWinner(int[] nums) {
        
        return check(nums,0,nums.length-1,0,0,1);
    //     int s1=0,s2=0,l=0,r=nums.length-1,flag=1;
    //     while(l<=r)
    //     {
    //         if(flag==1)
    //         {
    //             if(nums[l]>=nums[r])
    //                 s1+=nums[l++];
    //             else
    //                 s1+=nums[r--];
    //         }
    //         else
    //         {
    //             if(nums[l]>=nums[r])
    //                 s2+=nums[l++];
    //             else
    //                 s2+=nums[r--];
    //         }
    //         flag=flag ^ 1;
    //     }
    //     return s1>=s2;

     }
}