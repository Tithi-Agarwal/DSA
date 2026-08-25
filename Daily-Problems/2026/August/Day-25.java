//3718. Smallest Missing Multiple of K
import java.util.*;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);

        int i, j = 1;
        for( i = 0; i < nums.length; i++)
        {
            if(nums[i] == (j*k))
            {
                j++;
                continue;
            }
            if(nums[i] > (j*k))
                return (j*k);
        }
        return k*(j);
    }
}