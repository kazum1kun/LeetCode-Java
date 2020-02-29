import java.util.PriorityQueue;

/**
 * #215 Kth Largest Element in an Array https://leetcode.com/problems/kth-largest-element-in-an-array
 * 3ms/37.1 MB (beats 77.20%/90.16%)
 */
public class KLargestElement {
    public static void main(String[] args) {
        KLargestElement k = new KLargestElement();

        System.out.println(k.findKthLargest(new int[]{1, 8, 4, 3, 2}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || k > nums.length) return Integer.MIN_VALUE;

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else {
                if (pq.peek() < num) {
                    pq.poll();
                    pq.add(num);
                }
            }

        }

        return pq.poll();
    }
}
