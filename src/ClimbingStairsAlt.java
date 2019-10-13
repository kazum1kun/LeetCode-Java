/**
 * #70 Climbing Stairs https://leetcode.com/problems/climbing-stairs/
 * It is easy to see that to climb i steps, there are m[i-1]+m[i-2] possibilities
 * Given that there are 1 possibility to climb 1 step, 2 to climb 2 steps,
 * it is easy to infer # of possibilities to climb 3, 4, 5... steps
 * Closed form formula also exists but I hate math so let's not talk about it
 * Similar performance to the recursion version, which is kinda surprising
 */

public class ClimbingStairsAlt {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int a = 1, b = 2;

        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }
}
