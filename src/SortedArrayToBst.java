/**
 * #108 Convert Sorted Array to Binary Search Tree https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 0ms/36.6MB (beats 100.00%/100.00%)
 */

public class SortedArrayToBst {
    public static void main(String[] args) {
        SortedArrayToBst s = new SortedArrayToBst();
        TreeNode t = s.sortedArrayToBST(new int[]{-10, -5, -2, 0, 1, 3, 5, 7, 8});
        System.out.println(t);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) return null;

        return makeNode(nums, 0, nums.length - 1);
    }

    private TreeNode makeNode(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = makeNode(nums, start, mid - 1);
        root.right = makeNode(nums, mid + 1, end);

        return root;
    }
}
