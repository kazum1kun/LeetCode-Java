/**
 * #142 Linked List Cycle II https://leetcode.com/problems/linked-list-cycle-ii/
 * UNFINISHED
 */

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
