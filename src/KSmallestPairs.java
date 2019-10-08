import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * #373 Find K Pairs with Smallest Sums https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * 34ms/39.1MB (beats 56.53%/70.37%)
 */

public class KSmallestPairs {
    public static void main(String[] args) {
        KSmallestPairs k = new KSmallestPairs();
        k.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        PriorityQueue<int[]> pairs = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);

        for (int i = 0; i < nums1.length && i < k; i++) {
            pairs.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !pairs.isEmpty()) {
            int[] temp = pairs.poll();
            List<Integer> l = new ArrayList<>();
            l.add(temp[0]);
            l.add(temp[1]);
            result.add(l);

            if (temp[2] == nums2.length - 1) continue;

            pairs.offer(new int[]{temp[0], nums2[temp[2] + 1], temp[2] + 1});
        }
        return result;
    }
}
