/**
 * #111 Minimum Depth of Binary Tree https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 0ms/38.5MB (beats 100.0%/98.44%)
 */

public class BinaryTreeMinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        return findMin(root, 1);
    }

    private int findMin(TreeNode node, int level) {
        if (node == null) {
            return Integer.MAX_VALUE;
        } else if (node.right == null && node.left == null) {
            return level;
        }

        return Math.min(findMin(node.left, level + 1), findMin(node.right, level + 1));
    }
}
