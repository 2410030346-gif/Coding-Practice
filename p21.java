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
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy; // Tracks the node before current sequence

        while (head != null) {
            // If current node has duplicates
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect prev to the node after duplicates
                prev.next = head.next;
            } else {
                // No duplicate, move prev forward
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
