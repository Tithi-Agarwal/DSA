//1614. Maximum Nesting Depth of the Parentheses

class Solution {
    public int maxDepth(String s) {
        int open = 0, ans = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch =='(')
                open ++;
            if(ch == ')')
            {
                ans = Math.max(open, ans);
                open --;
            }
        }
        return ans;
    }
}