import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;

        // Sort the interval by start time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        // Use priority queue to store rooms
        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o.end));

        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval soonest = pq.poll();
            // Merge two meetings if they don't overlap
            if (intervals[i].start >= soonest.end) {
                soonest.end = intervals[i].end;
            } else {
                // Start a new meeting room
                pq.offer(intervals[i]);
            }
            pq.offer(soonest);
        }

        return pq.size();
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
