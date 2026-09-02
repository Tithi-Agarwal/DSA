//2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

/**
 * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
 */

import java.util.*;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public int[] nodesBetweenCriticalPoints(ListNode head) {
    if (head.next == null)
      return new int[] { -1, -1 };

    int ans[] = new int[2];
    ListNode temp = head, prev = null, nex = head.next;
    ArrayList<Integer> pos = new ArrayList<>();
    int curr = 1;

    while (temp != null && nex != null) {
      if (prev != null && nex != null) {
        int curr_val = temp.val, prev_val = prev.val, next_val = nex.val;
        if ((curr_val > prev_val && curr_val > next_val) || (curr_val < prev_val && curr_val < next_val))
          pos.add(curr);
      }
      prev = temp;
      temp = nex;
      nex = nex.next;
      curr++;
    }

    if (pos.size() < 2) {
      ans[0] = -1;
      ans[1] = -1;
    } else {
      for (int ele : pos)
        System.out.print(ele);
      ans[1] = pos.get(pos.size() - 1) - pos.get(0);
      ans[0] = Integer.MAX_VALUE;
      for (int i = 1; i < pos.size(); i++) {
        ans[0] = Math.min(ans[0], pos.get(i) - pos.get(i - 1));
      }
    }

    return ans;

  }
}