// 3622. Check Divisibility by Digit Sum and Product

class Solution {
    public boolean checkDivisibility(int n) {
        int d, p = 1, s = 0, num = n;
        while(n > 0)
        {
            d = n % 10;
            s+= d;
            p*= d;
            n = n / 10;
        }
        if(num%(p+s) == 0)
            return true;
        return false;
    }
}