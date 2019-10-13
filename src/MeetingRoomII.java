import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * #253 Meeting Rooms II https://leetcode.com/problems/meeting-rooms-ii/
 * Updated to the new signature
 * 38ms/37.2MB (beats 27.30%/71.79%)
 */
public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;

        // Sort the interval by start time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // Use priority queue to store rooms
        PriorityQueue<int[]> pq = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o[1]));

        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] soonest = pq.poll();
            // Merge two meetings if they don't overlap
            if (intervals[i][0] >= soonest[1]) {
                soonest[1] = intervals[i][1];
            } else {
                // Start a new meeting room
                pq.offer(intervals[i]);
            }
            pq.offer(soonest);
        }

        return pq.size();
    }
}
