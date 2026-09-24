//3550. Smallest Index With Digit Sum Equal to Index

class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            int ele = nums[i];
            int s = 0;
            while(ele > 0)
            {
                s += ele % 10;
                ele /= 10;
            }
            if(s == i)
                return i;
        }
        return -1;
    }
}