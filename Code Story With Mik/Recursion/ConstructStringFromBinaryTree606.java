
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
  this.val = val;
  this.left = left;
  this.right = right;
  }
  }
 

public record ConstructStringFromBinaryTree606() {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        String result = Integer.toString(root.val);

        String Left = tree2str(root.left);
        String Right = tree2str(root.right);

        if (root.left == null && root.right == null) {
            return result;
        }

        if (root.right == null) {
            return result + "(" + Left + ")";
        }

        if (root.left == null) {
            return result + "()" + "(" + Right + ")";
        }

        return result + "(" + Left + ")" + "(" + Right + ")";
    }
}
