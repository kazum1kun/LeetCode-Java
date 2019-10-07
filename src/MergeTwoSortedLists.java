/**
 * #21 Merge Two Sorted Lists https://leetcode.com/problems/merge-two-sorted-lists/
 * 0ms/39.7MB (Beats 100.00%/16.16%)
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return  l1;
        }
        ListNode head, retHead;

        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else  {
            head = l2;
            l2 = l2.next;
        }

        retHead = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else  {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        if (l1 != null) {
            head.next = l1;
        } else if (l2 != null) {
            head.next = l2;
        }

        return retHead;
    }
}
