//2091. Removing Minimum and Maximum From Array

class Solution {
    public int minimumDeletions(int[] nums) {
        int maxEle = Integer.MIN_VALUE, minEle = Integer.MAX_VALUE, maxInd = 0, minInd = 0, n = nums.length;

        for(int i = 0; i < n; i++)
        {
            if(nums[i] < minEle)
            {
                minEle = nums[i];
                minInd = i;
            }
            if(nums[i] > maxEle)
            {
                maxEle = nums[i];
                maxInd = i;
            }
        }

        int maxDel, minDel, ans;
        maxDel = Math.min(maxInd + 1, n - maxInd);
        minDel = Math.min(minInd + 1, n - minInd);

        if(Math.abs(maxInd - minInd) < Math.max(maxDel, minDel)) //if the distance between them is less than their distance from the ends 
            ans = Math.min(maxDel, minDel) + Math.abs(maxInd - minInd);
        else
            ans = maxDel + minDel;

        return ans;
    }
}