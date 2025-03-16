/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ele = 0;
    int max = 0;
    public void solve(TreeNode root, int len) {
        if(root == null) {
            return;
        }
        solve(root.left, len + 1);
        solve(root.right, len + 1);

        if(len > max) {
            max = len;
            ele = root.val;
        }

    }
    public int findBottomLeftValue(TreeNode root) {
        ele = root.val;
        solve(root, 0);
        return ele;
    }
}
