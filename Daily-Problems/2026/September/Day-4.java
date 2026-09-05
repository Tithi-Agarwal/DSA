//3903. Smallest Stable Index I

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length, max = Integer.MIN_VALUE;
        int sm[] = new int[n];
        sm[n-1] = nums[n-1];
        for(int i = n-1; i >= 1; i--)
        {
            if(sm[i] > nums[i-1])
                sm[i-1] = nums[i-1];
            else
                sm[i-1] = sm[i];
        }

        for(int i = 0; i < n; i++)
        {
            max = Math.max(max, nums[i]);
            if(max - sm[i] <= k)
                return i;
        }
        
        return -1;
    }
}