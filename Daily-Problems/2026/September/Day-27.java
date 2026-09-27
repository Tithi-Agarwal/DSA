//1190. Reverse Substrings Between Each Pair of Parentheses
import java.util.*;

class Solution {
    public String reverseParentheses(String s) {
        char chs[] = s.toCharArray();
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(char ch: chs)
        {
            if(ch == '(')
            {
                st.push(sb);
                sb = new StringBuilder("");
            }
            else if(ch ==')')
            {
                sb.reverse();
                if(!st.isEmpty())
                    sb = (st.pop()).append(sb);
            }
            else
            sb.append(ch);
        }
        return sb.toString();
    }
}