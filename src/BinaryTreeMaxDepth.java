/**
 * #104 Maximum Depth of Binary Tree https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 0ms/39.1MB (beats 100.0%/94.62%)
 */

public class BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int localMax = Math.max(maxDepth(root.left), maxDepth(root.right));

        return localMax + 1;
    }
}
