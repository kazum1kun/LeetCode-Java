import java.util.*;

/**
 * #973 K Closest Points to Origin https://leetcode.com/problems/k-closest-points-to-origin/
 * Algorithm:
 * 1) Set up a priority queue where priority is determined by the point's Euclidean distance to the origin
 * 2) Add all points to the queue
 * 3) Pull K points from the queue
 * Not very efficient, but hey it's darn simple!
 * 58ms/62MB (beats 22.63/41.62%)
 */

public class KClosestPoint {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pointsQueue = new PriorityQueue<>
                ((p1, p2) -> -(p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]));

        pointsQueue.addAll(Arrays.asList(points));

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            result.add(pointsQueue.poll());
        }

        return result.toArray(new int[0][0]);
    }
}
