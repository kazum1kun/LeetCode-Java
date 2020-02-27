import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * #863 All Nodes Distance K in Binary Tree https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class KDistanceNodes {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        return null;
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

    private void traverseTree(TreeNode node, int K, Map<TreeNode, TreeNode> parentMap, List<Integer> result) {
        if (node == null) return;


    }
}
