import java.util.HashMap;

/**
 * #146 LRU Cache (Alt HashMap+DLinkList Impl) https://leetcode.com/problems/lru-cache/
 * 56ms/50.6MB (Beats 92.22%/96.93%)
 */
public class LRUCacheAlt {
    private DLinkListNode head, tail;
    private int CAPACITY;
    private HashMap<Integer, DLinkListNode> map;

    class DLinkListNode {
        int key, value;
        DLinkListNode prev, next;

        DLinkListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        DLinkListNode() {}
    }

    public LRUCacheAlt(int capacity) {
        CAPACITY = capacity;
        map = new HashMap<>(CAPACITY);
        // Create head and tail
        head = new DLinkListNode();
        tail = new DLinkListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkListNode temp = map.get(key);
        if (temp == null) return -1;
        else {
            moveNodeToFront(temp);
            return temp.value;
        }
    }

    public void put(int key, int value) {
        DLinkListNode temp = map.get(key);
        if (temp != null) {
            temp.value = value;
            moveNodeToFront(temp);
        } else {
            DLinkListNode newNode = new DLinkListNode(key, value);
            if (map.size() == CAPACITY) {
                evictLastAccessed();
                insertNode(newNode);
            } else {
                insertNode(newNode);
            }
        }
    }

    private void insertNode(DLinkListNode newNode) {
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        map.put(newNode.key, newNode);
    }

    private void evictLastAccessed() {
        map.remove(tail.prev.key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    private void moveNodeToFront(DLinkListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCacheAlt cache = new LRUCacheAlt(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
