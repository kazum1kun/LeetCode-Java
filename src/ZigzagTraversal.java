import java.util.ArrayList;
import java.util.List;

/**
 * #103 Binary Tree Zigzag Level Order Traversal https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 1ms/36.3MB (beats 98.77%/99.04%)
 */
// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        travel(root, 0, result);
        return result;
    }

    private void travel(TreeNode s, int level, List<List<Integer>> result) {
        if (s == null) return;

        if (result.size() <= level) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }

        // Odd numbers: RTL; even numbers: LTR
        List<Integer> temp = result.get(level);
        if (level % 2 == 0) {
            temp.add(s.val);
        } else {
            temp.add(0, s.val);
        }

        travel(s.left, level + 1, result);
        travel(s.right, level + 1, result);
    }
}
