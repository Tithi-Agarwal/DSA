//1021. Remove Outermost Parentheses

class Solution {
    public String removeOuterParentheses(String s) {

        
        StringBuilder  ans = new StringBuilder();
        int cnt = 0 ;

        for( char c : s.toCharArray()){
            if(c == '('){
                if(cnt > 0 ) ans.append(c);
                cnt++;
            }else{
            cnt--;
            if(cnt>0) ans.append(c);
        }
            
        }

        return ans.toString();
        
    }
}
