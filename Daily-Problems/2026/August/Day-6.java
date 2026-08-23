//3345. Smallest Divisible Digit Product I

class Solution {
    public int smallestNumber(int n, int t) {
        int d, num, p;
        while(true)
        {
            num = n;
            p = 1;
            while(n>0)
            {
                d = n % 10;
                n = n / 10;
                p = p * d;
            }
            if(p % t == 0)
                return num;
            else
                n = num + 1;
        }
        
    }
}