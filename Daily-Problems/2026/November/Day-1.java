//453. Minimum Moves to Equal Array Elements
import java.util.*;

class Solution {
    public int minMoves(int[] nums) {
        int ans = 0, n = nums.length;
        Arrays.sort(nums);
        int min = 0, max = n - 1;
        while(min <= max)
        {
            ans += nums[max] - nums[min]; //the difference between the elements remain constant just the maximum ele keeps shifting to left
            max--;
        }
        return ans;
    }
}