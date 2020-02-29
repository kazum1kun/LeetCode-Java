// #352 Data Stream as Disjoint Intervals

import java.util.Map;
import java.util.TreeMap;

public class DisjointIntervals {
    Map<Integer, Interval> intervalMap;

    /**
     * Initialize your data structure here.
     */
    public DisjointIntervals() {
        intervalMap = new TreeMap<>();
    }

    public void addNum(int val) {

    }

    public int[][] getIntervals() {
        return intervalMap.
    }

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
