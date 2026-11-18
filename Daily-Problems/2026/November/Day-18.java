//2914. Minimum Number of Changes to Make Binary String Beautiful

class Solution {
    public int minChanges(String s) {
        int n = s.length(), count = 0, ans = 0, flag = 0;
        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == '0')  // if 0 encountered
            {
                if(flag == 0)       // check if previous was also a zero continue
                    count++;
                else
                {
                    if(count % 2 != 0)      //incase previous was 1 check for previous record continous 1
                    {
                        count = 2;          //if 1's was odd length we need to change one 1 to 0
                        ans++;              //that changed 0 should also be counted making count = 2
                    }
                    else    
                        count = 1;          // if even length just keep a count of the new 0 so count = 1
                    flag = 0;
                }
            }
            else
            {
                if(flag == 1)                 //same pattern vice versa
                    count++;
                else
                {
                    if(count % 2 != 0)
                    {
                        count = 2;
                        ans++;
                    }
                    else
                        count = 1;
                    flag = 1;
                }
            }
        }
        return ans + (count % 2);

    }
}