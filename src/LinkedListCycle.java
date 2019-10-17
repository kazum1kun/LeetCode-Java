import java.util.HashSet;
import java.util.Set;

/**
 * #141 Linked List Cycle https://leetcode.com/problems/linked-list-cycle/
 * This question is very poorly written. Not sure what they are even talking about...
 * 6ms/38.7MB (beats 6.52%/43.75%)
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        Set<Integer> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head.hashCode())) {
                return true;
            } else {
                seen.add(head.hashCode());
            }
            head = head.next;
        }
        return false;
    }
}
