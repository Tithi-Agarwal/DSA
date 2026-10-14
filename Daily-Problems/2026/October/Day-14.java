//3723. Maximize Sum of Squares of Digits

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder s = new StringBuilder();
        for(int i = 1; i <= num; i++)
        {
            for(int j = 9; j >= 0; j--)
            {
                if(j > sum)
                    continue;
                s.append(j);
                sum -= j;
                break; 
            }
        }
        if(sum != 0)
            return "";
        return s.toString();
    }
}
