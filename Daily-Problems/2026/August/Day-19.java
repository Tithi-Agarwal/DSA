//3069. Distribute Elements Into Two Arrays I

import java.util.*;

class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int ind1 = 0, ind2 = 0, last1, last2;

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i < nums.length; i++)
        {
            last1 = arr1.get(ind1);
            last2 = arr2.get(ind2);

            if(last1 > last2)
            {
                arr1.add(nums[i]);
                ind1++;
            }
            else
            {
                arr2.add(nums[i]);
                ind2++;
            }
        }

        int ans[] = new int[nums.length];
        for(int i = 0; i < arr1.size(); i++)
        {
            ans[i] = arr1.get(i);
        }
         for(int i = 0; i < arr2.size(); i++)
        {
            ans[i + arr1.size()] = arr2.get(i);
        }

        return ans;
    }
}