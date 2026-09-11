//3483. Unique 3-Digit Even Numbers
import java.util.*;

class Solution {
    public void check(int[] nums, int ind, int place, int curr,
                      HashSet<Integer> set, boolean[] used) {

        if(place == 4) {
            set.add(curr);
            return;
        }

        if(ind == nums.length)
            return;

        if(!used[ind]) {

            if(place == 1 && nums[ind] == 0) {
                check(nums, ind + 1, place, curr, set, used);
            }
            else if(place == 3 && nums[ind] % 2 != 0) {
                check(nums, ind + 1, place, curr, set, used);
            }
            else {
                used[ind] = true;

                check(nums, 0, place + 1,
                      curr * 10 + nums[ind], set, used);

                used[ind] = false;

                check(nums, ind + 1, place, curr, set, used);
            }
        }
        else {
            check(nums, ind + 1, place, curr, set, used);
        }
    }

    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        boolean[] used = new boolean[digits.length];

        check(digits, 0, 1, 0, set, used);

        return set.size();
    }
}