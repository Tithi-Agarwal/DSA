//3727. Maximum Alternating Sum of Squares

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long sum = 0;
        int s = 0, e = n - 1;
        for(int i = 0; i < n; i++)
        {
            if( i % 2 != 0)
            {
                sum -= Math.pow(nums[s], 2);
                s++;
            }
            else
            {
                sum += Math.pow(nums[e], 2);
                e--;
            }   
        }
        return sum;
    }
}
