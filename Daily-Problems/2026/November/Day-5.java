//1385. Find the Distance Value Between Two Arrays

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int min = arr2[0], max = arr2[arr2.length - 1], ans = 0;
        for(int i = 0; i < arr1.length; i++)
        {
            if(Math.abs(max - arr1[i]) <= d  || Math.abs(min - arr1[i]) <= d)
                continue;
            ans++;
        }
        return ans;
    }
}
