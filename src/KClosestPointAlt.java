import java.util.*;

/**
 * #973 K Closest Points to Origin https://leetcode.com/problems/k-closest-points-to-origin/
 * Alternative Implementation: simply changing the way that info is stored can lead to
 * somewhat improved performance.
 * 50ms/65.9MB (Beats 40.43%/8.70%)
 */

public class KClosestPointAlt {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pointsQueue = new PriorityQueue<>
                ((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);

        for (int[] point : points) {
            pointsQueue.offer(point);
            if (pointsQueue.size() > K) {
                pointsQueue.poll();
            }
        }

        return pointsQueue.toArray(new int[0][]);
    }
}
