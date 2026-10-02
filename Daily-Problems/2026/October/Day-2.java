//22. Generate Parentheses
import java.util.*;

class Solution {
    void print(int open,int close,List<String> res,StringBuilder str,int n)
    {
        if(str.length()==2*n)
        {
            res.add(str.toString());
            return;
        }
        if(open<n)
        {
            str.append("(");
            print(open+1,close,res,str,n);
            str.deleteCharAt(str.length()-1);
        }
        if(open>close)
        {
            str.append(")");
            print(open,close+1,res,str,n);
            str.deleteCharAt(str.length()-1);
        }
        
        
        
    }
    public List<String> generateParenthesis(int n) {
        int open=0,close=0;
        List<String> res=new ArrayList<>();
        print(open,close,res,new StringBuilder(),n);
        return res;
    }
}