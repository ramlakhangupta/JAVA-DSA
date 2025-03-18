/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];

            if (!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }

            if (!map.containsKey(child)) {
                map.put(child, new TreeNode(child));
            }

            if (isLeft == 1) {
                map.get(parent).left = map.get(child);
            } else {
                map.get(parent).right = map.get(child);
            }
            set.add(child);
        }

        // find root node
        for (int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];
            if (!set.contains(parent)) {
                return map.get(parent);
            }
        }
        return null;
    }
}
