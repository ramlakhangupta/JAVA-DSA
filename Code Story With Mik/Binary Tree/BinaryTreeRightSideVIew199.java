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

    public void solve(TreeNode root, List<Integer> ans, int level) {
        if (root == null) {
            return;
        }

        if (ans.size() < level) {
            ans.add(root.val);
        }

        solve(root.right, ans, level + 1);
        solve(root.left, ans, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        solve(root, ans, 1);

        return ans;
    }
}
