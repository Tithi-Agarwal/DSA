//3105. Longest Strictly Increasing or Strictly Decreasing Subarray

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1, curr1 = 1, curr2 = 1;//curr1 for increasin 2 for decreasing
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > nums[i - 1])
            {
                curr1++;
                curr2 = 1;
            }
            else if(nums[i] < nums[i - 1])
            {
                curr1 = 1;
                curr2++;
            }
            else
            {
                curr1 = 1;
                curr2 = 1;
            }
            ans = Math.max(ans, Math.max(curr1, curr2));
        }
        return ans;
    }
}