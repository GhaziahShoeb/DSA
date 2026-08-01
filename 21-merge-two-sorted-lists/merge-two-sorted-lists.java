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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> arr = new ArrayList<>();

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null) {
            arr.add(temp1.val);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            arr.add(temp2.val);
            temp2 = temp2.next;
        }
        Collections.sort(arr);
        ListNode head = convert(arr);
        return head;
    }

    /*
    private ListNode convert(List<Integer> arr){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for(int val : arr){
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
    */

    private ListNode convert(List<Integer> arr) {
        ListNode head = null;
        ListNode curr = null;

        for (int val : arr) {
            if (head == null) {
                head = new ListNode(val);  // special case: first node
                curr = head;
            } else {
                curr.next = new ListNode(val);  // normal case
                curr = curr.next;
            }
        }

        return head;
    }
}