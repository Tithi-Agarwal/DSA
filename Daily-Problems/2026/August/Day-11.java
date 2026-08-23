//2958. Length of Longest Subarray With at Most K Frequency
import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0, n = nums.length, freq = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        int left = 0, right = 0;
        while(left <= right && right < n)
        {
            freq = map.getOrDefault(nums[right], 0);
            if(freq == k)
            {
                while(nums[left] != nums[right])
                {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    left++;
                }
                left++;
            }
            else
                map.put(nums[right], freq + 1);

            max = Math.max(max, right - left + 1);
            right ++;
        }

        return max;

        // for(int i = 0; i < n; i++)
        // {
        //     freq = map.getOrDefault(nums[i],0);
        //     if(freq >= k)
        //     {
        //         c = 0;
        //         map.delete
        //     }
        //     else
        //     {
        //         map.put(nums[i], freq + 1);
        //         c++;
        //         max = Math.max(max, c);
        //     }
        // }
        // return max;
    }
}