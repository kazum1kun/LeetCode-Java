import java.util.Arrays;
import java.util.Comparator;

/**
 * #38 Meeting Room https://leetcode.com/problems/meeting-rooms/
 * Updated to the new method signature
 * 40ms/38MB (beats 6.30%/43.59%)
 */

public class MeetingRoom {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }
}
