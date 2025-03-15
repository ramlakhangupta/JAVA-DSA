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
    Map<TreeNode, TreeNode> map = new HashMap<>();
    TreeNode head = new TreeNode();

    public void addParent(TreeNode root, int start) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }

        if (root.val == start) {
            head = root;
        }

        addParent(root.left, start);

        if (root.right != null) {
            map.put(root.right, root);
        }
        addParent(root.right, start);

    }

    public int amountOfTime(TreeNode root, int start) {
        addParent(root, start);
        Queue<TreeNode> que = new LinkedList<>();
        que.add(head);
        Set<Integer> visited = new HashSet<>();
        visited.add(head.val);
        int count = 0;

        while (!que.isEmpty()) {
            int n = que.size();
            while (n > 0) {
                TreeNode curr = que.poll();

                if (curr.left != null && !visited.contains(curr.left.val)) {
                    que.add(curr.left);
                    visited.add(curr.left.val);
                }

                if (curr.right != null && !visited.contains(curr.right.val)) {
                    que.add(curr.right);
                    visited.add(curr.right.val);
                }

                if (map.containsKey(curr) && !visited.contains(map.get(curr).val)) {
                    que.add(map.get(curr));
                    visited.add(map.get(curr).val);
                }
                n--;
            }
            count++;
        }

        return count - 1;
    }
}
