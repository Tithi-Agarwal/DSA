//2124. Check if All A's Appears Before All B's

class Solution {
    public boolean checkString(String s) {
        int counter = 0;
        for(char ch: s.toCharArray())
        {
            if(ch == 'b')       // the moment we find b we start counting
                counter++;
            else
                if(counter > 0)     // if a encountered after count > 0 then false (works like a flag)
                    return false;
            
        }
        return true;
    }
}
