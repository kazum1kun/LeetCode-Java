/**
 * #33 Search in Rotated Sorted Array https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Divide and conquer method
 * 0ms/40.1 MB (beats 100%/13.21%)
 */

public class SearchInRotatedArray {
    private int result = -1;

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        searchSubArray(nums, target, 0, nums.length - 1);
        return result;
    }

    private void searchSubArray (int[] nums, int target, int begin, int end) {
        if (nums[begin] < nums[end] && (target < nums[begin] || target > nums[end]))
            return;

        if (begin == end) {
            if (nums[begin] == target) {
                result = begin;
                return;
            } else return;
        }

        searchSubArray(nums, target, begin, begin+(end-begin)/2);
        searchSubArray(nums, target, begin+(end-begin)/2+1, end);
    }

    public static void main(String[] args) {
        SearchInRotatedArray sir = new SearchInRotatedArray();
        System.out.println(sir.search(new int[]{4,5,6,7,0,1,2}, 5));    // 1
    }
}
