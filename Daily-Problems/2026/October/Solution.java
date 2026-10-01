//20
import java.util.*;

public class Solution {
    public static boolean isValid(String s) 
    {
        int i;
        char ch;
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(i=0;i<n;i++)
        {
            ch=s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{')
            st.push(ch);
            else
            {
                if(st.isEmpty())
                return false;
                if((ch==')' && st.peek()!='(')||(ch==']' && st.peek()!='[')||(ch=='}' && st.peek()!='{'))
                return false;
                st.pop();
            }
            

        }
        if(st.isEmpty())
        return true;
        return false;
    }
}

   