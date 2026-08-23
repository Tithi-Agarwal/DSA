//3090. Maximum Length Substring With Two Occurrences

import java.util.*;

class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0, left = 0, right = 0, freq, n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        while(left <= right && right < n)
        {
            char ch = s.charAt(right);
            freq = map.getOrDefault(ch, 0);
            if(freq == 2)
            {
                while(s.charAt(left) != ch)
                {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    left++;
                }
                left++;
            }
            else
                map.put(ch, freq + 1);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}