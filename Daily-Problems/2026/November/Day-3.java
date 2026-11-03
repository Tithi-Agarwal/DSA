//3736. Minimum Moves to Equal Array Elements III

class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int ele: nums)
        {
            if(ele > max)
                max = ele;
        }
        int ans = 0;
        for(int ele: nums)
        {
            ans += max - ele;
        }
        return ans;
    }
}