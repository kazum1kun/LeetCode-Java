import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * #863 All Nodes Distance K in Binary Tree https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class KDistanceNodes {
    private Map<TreeNode, TreeNode> parentMap;

    public static void main(String[] args) {
        KDistanceNodes k = new KDistanceNodes();

        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(2);
        tree.left.right = new TreeNode(6);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(3);

        List<Integer> result = k.distanceK(tree, tree.left.right, 2);

        for (int r : result) System.out.print(r + " ");
    }

    private void buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) return;

        buildParentMap(root.left, parentMap);

        if (root.left != null) {
            parentMap.put(root.left, root);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
        }

        buildParentMap(root.right, parentMap);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        traverseTree(target, K, result, 's');

        return result;
    }

    private void traverseTree(TreeNode node, int K, List<Integer> result, char direction) {
        if (node == null) return;

        if (K == 0) {
            result.add(node.val);
            return;
        }

        // Do not rescan the way it comes from
        if (direction != 'r') {
            traverseTree(node.right, K - 1, result, 'p');
        }
        if (direction != 'l') {
            traverseTree(node.left, K - 1, result, 'p');
        }
        if (direction != 'p') {
            // Determine if it is of left or right tree
            TreeNode parent = parentMap.get(node);
            if (parent == null) return;

            char dir = (parent.left == node) ? 'l' : 'r';

            traverseTree(parent, K - 1, result, dir);
        }
    }
}
