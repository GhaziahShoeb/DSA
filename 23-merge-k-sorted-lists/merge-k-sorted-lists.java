/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> arr = new ArrayList<>();

        // loop through every list in the array
        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while (temp != null) {
                arr.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(arr);
        ListNode head = convert(arr);
        return head;
    }

    private ListNode convert(List<Integer> arr) {
        ListNode head = null;
        ListNode curr = null;

        for (int val : arr) {
            if (head == null) {
                head = new ListNode(val);
                curr = head;
            } else {
                curr.next = new ListNode(val);
                curr = curr.next;
            }
        }

        return head;  // this was missing!
    }
}