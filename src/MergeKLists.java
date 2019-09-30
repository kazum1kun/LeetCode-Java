import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * #23 Merge k Sorted Lists https://leetcode.com/problems/merge-k-sorted-lists/
 * 39ms/40.9M (Beats 21.09%/46.45%)
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class MergeKLists {
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
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (!pq.isEmpty() && pq.size() > 1) {
            current.val = pq.poll().val;
            current.next = new ListNode(0);
            current = current.next;
        }
        current.val = pq.poll().val;

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
        ListNode result = MergeKLists.mergeKLists(lists);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
