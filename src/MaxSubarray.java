/**
 * #58 Maximum Subarray https://leetcode.com/problems/maximum-subarray/
 * 0ms/37.5MB (Beats 100.00%/99.53%)
 */

public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int localMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], nums[i] + localMax);
            globalMax = Math.max(localMax, globalMax);
        }

        return globalMax;
    }
}
