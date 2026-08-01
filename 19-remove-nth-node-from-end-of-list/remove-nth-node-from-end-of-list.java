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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        if (count == n) {
            return head.next;
        }

        int res = count - n;
        temp = head;  // reset temp back to head

        while (temp != null) {
            res--;
            if (res == 0) {
                temp.next = temp.next.next;  // delete the target node
                break;
            }
            temp = temp.next;  // only move forward if we haven't reached the spot yet
        }

        return head;
    }
}