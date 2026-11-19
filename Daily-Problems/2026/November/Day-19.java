//2567. Minimum Score by Changing Two Elements
import java.util.*;

class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        //case 1 - change the 1st 2 ele to become same so min = 0, max = last - 3rd
        //case 2 - change the last 2 ele to become same so min = 0, max = 3rd last - first
        //case 3 - change the 1st to become same as 2nd, last to become same as 2nd last, so min = 0 max = 2nd - 2nd last
        if(n >= 3)
            return Math.min(nums[n - 1] - nums[2], Math.min(nums[n - 3] - nums[0], nums[n - 2] - nums[1]));
        return 0;
        

    }
}