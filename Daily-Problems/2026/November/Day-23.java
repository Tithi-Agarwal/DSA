//1352. Product of the Last K Numbers
import java.util.*;

class ProductOfNumbers {
    ArrayList<Integer> stream ;
    public ProductOfNumbers() {
        stream = new ArrayList<>();
    }
    
    public void add(int num) {
        stream.add(num);
    }
    
    public int getProduct(int k) {
        int n = stream.size(), p = 1;
        for(int i = n - k; i < n; i++)
            p = p * stream.get(i);
        return p;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */