//3498. Reverse Degree of a String

class Solution {
    public int reverseDegree(String s) {
        int ans = 0, ind = 1;
        for(char ch: s.toCharArray())
        {
            int org = ch - 97;
            int rev = 26 - org;
            ans+= ind++ * rev;
        }
        return ans;
    }
}