public class BalancedBinaryTree110 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    //Recursive Approach
    public int levels1(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(levels1(root.left), levels1(root.right));

    }

    public boolean isBalanced1(TreeNode root) {
        if (root == null)
            return true;
        int diff = Math.abs(levels1(root.left) - levels1(root.right));
        if (diff > 1) {
            return false;
        }
        return isBalanced1(root.left) && isBalanced1(root.right);
    }


    //Optimal Approach 
    static boolean ans;
    public int levels(TreeNode root) {
        if (root == null) return 0;
        int leftLevel = levels(root.left);
        int rightLevel = levels(root.right);
        int diff = Math.abs(leftLevel - rightLevel);
        if (diff>1)  ans = false;

        return 1 + Math.max(leftLevel, rightLevel);

    }

    public boolean isBalanced(TreeNode root) {
        ans = true;
        levels(root);
        return ans;
    } 
}
