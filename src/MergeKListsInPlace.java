import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * #23 Merge k Sorted Lists https://leetcode.com/problems/merge-k-sorted-lists/
 * Alternative Impl.
 */

public class MergeKListsInPlace {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // Custom comparator
        Comparator<ListNode> listNodeComparator = Comparator.comparingInt(n -> n.val);

        // Add all lists to the PQ
        PriorityQueue<ListNode> pq = new PriorityQueue<>(listNodeComparator);
        for (ListNode node : lists) {
            while (node != null) {
                pq.add(node);
                node = node.next;
            }
        }

        if (pq.isEmpty()) return null;

        // Find the first smallest node to begin with
        ListNode current, head;
        current = head = pq.poll();

        while (!pq.isEmpty()) {
            current.next = pq.poll();
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(10);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        ListNode l3 = new ListNode(7);
        l3.next = new ListNode(8);
        l3.next.next = new ListNode(9);

        ListNode[] lists = new ListNode[]{l1, l2, l3};
        ListNode result = MergeKListsInPlace.mergeKLists(lists);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
