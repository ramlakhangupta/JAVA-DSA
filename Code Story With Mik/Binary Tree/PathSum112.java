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

class Temp {
    boolean a;
}

class Solution {

    public void solve(TreeNode root, int targetSum, int sum, Temp tem) {
        if (root == null) {
            return;
        }

        sum += root.val;
        if (sum == targetSum && root.left == null && root.right == null) {
            tem.a = true;

        } else {
            solve(root.left, targetSum, sum, tem);
            solve(root.right, targetSum, sum, tem);

        }
        sum -= root.val;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        Temp tem = new Temp();
        tem.a = false;
        int sum = 0;
        solve(root, targetSum, sum, tem);
        return tem.a;
    }
}
