import java.util.HashSet;
import java.util.Set;

/**
 * #141 Linked List Cycle https://leetcode.com/problems/linked-list-cycle/
 * Alternative (2 pointers) impl.
 * 0ms/37.2MB (beats 100.00%/100.00%)
 */

public class LinkedListCycleAlt {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
