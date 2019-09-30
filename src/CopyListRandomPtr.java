import java.util.HashMap;

/**
 * #138 Copy List with Random Pointer https://leetcode.com/problems/copy-list-with-random-pointer/
 * 1ms/34.1MB (Beats 74.07%/99.07%)
 */

public class CopyListRandomPtr {
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node iter = head;
        Node returnHead = new Node();
        HashMap<Integer, Node> nodes = new HashMap<>();

        while (iter != null) {
            if (nodes.size() == 0) {
                returnHead = new Node(iter.val, null, null);
                nodes.put(iter.val, returnHead);
            } else {
                nodes.put(iter.val, new Node(iter.val, null, null));
            }
            iter = iter.next;
        }

        iter = head;
        while (iter != null) {
            if (iter.next != null) {
                nodes.get(iter.val).next = nodes.get(iter.next.val);
            }
            if (iter.random != null) {
                nodes.get(iter.val).random = nodes.get(iter.random.val);
            }
            iter = iter.next;
        }

        return returnHead;
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        node1.val = 1;
        node1.next = node2;
        node1.random = node2;
        node2.val = 2;
        node2.random = node2;
        node2.next = null;

        Node rtr = CopyListRandomPtr.copyRandomList(node1);
        System.out.println(rtr);
    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}