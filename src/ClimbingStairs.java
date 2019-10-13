/**
 * #70 Climbing Stairs https://leetcode.com/problems/climbing-stairs/
 * Recursion with memorization version (regular recursion fails quickly when n is large)
 * 0ms/33.2MB (beats 100.00%/5.26%)
 */

public class ClimbingStairs {
    private int[] m;

    public static void main(String[] args) {
        ClimbingStairs s = new ClimbingStairs();
        System.out.println(s.climbStairs(1000));
    }

    public int climbStairs(int n) {
        m = new int[n + 1];
        return climb(0, n);
    }

    private int climb(int currentLevel, int n) {
        if (currentLevel == n) {
            return 1;
        } else if (currentLevel > n) {
            return 0;
        } else if (m[currentLevel] != 0) {
            return m[currentLevel];
        } else {
            m[currentLevel] = climb(currentLevel + 1, n) + climb(currentLevel + 2, n);
            return m[currentLevel];
        }
    }
}
