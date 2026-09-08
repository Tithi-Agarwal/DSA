//3870. Count Commas in Range

class Solution {
    public int countCommas(int n) {
        //then everyone else has 1 comma(1,000s 10,000s 100,000)
        //so we just count numbers from 1000
        return (n<1000)?0:(n - 999);
    }
}