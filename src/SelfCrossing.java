/**
 * #335 Self Crossing https://leetcode.com/problems/self-crossing/
 * 0ms/34.2MB (beats 100.00%/100.00%)
 */

public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        int len = x.length;

        /* Array index and direction
            0  1  2  3  4  5  6  7  ...
            N  W  S  E  N  W  S  E  ...
         */
        for (int i = 3; i < len; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;
            if (i >= 4) {
                if (x[i - 3] == x[i - 1] && x[i] + x[i - 4] >= x[i - 2]) return true;
            }
            if (i >= 5) {
                if (x[i - 4] + x[i] >= x[i - 2] && x[i - 5] + x[i - 1] >= x[i - 3] && x[i - 2] >= x[i - 4] && x[i - 1] <= x[i - 3])
                    return true;
            }
        }

        return false;
    }
}
