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
        // Create a dummy node before head to handle edge cases
        // (e.g., removing the head itself)
        ListNode dummy = new ListNode(0, head);

        // Initialize slow and fast pointers at dummy
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast pointer n+1 steps ahead to create a gap of n nodes
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers together until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow is now at the node just BEFORE the target → delete target node
        slow.next = slow.next.next;

        // Return updated head (dummy.next in case the real head was removed)
        return dummy.next;
    }
}