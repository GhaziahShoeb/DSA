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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // find the middle using slow/fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // split into two halves
        ListNode secondHalf = slow.next;
        slow.next = null;

        // reverse the second half
        ListNode prev = null;
        ListNode curr = secondHalf;
        while (curr != null) {
            ListNode next = curr.next; //copyi do
            curr.next = prev; //  overwrite,"flip the arrow backward"
            prev = curr;
            curr = next;
        }

        // merge alternately
        ListNode l1 = head;
        ListNode l2 = prev;
        while (l2 != null) {
            ListNode t1 = l1.next;
            ListNode t2 = l2.next;
            l1.next = l2;
            l2.next = t1;
            l1 = t1;
            l2 = t2;
        }
    }
}