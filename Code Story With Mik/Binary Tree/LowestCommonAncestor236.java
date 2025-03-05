/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public void solve(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> list1, List<TreeNode> list2,
            List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);

        if (root == p) {
            list1.addAll(new ArrayList<>(list));
        }

        if (root == q) {
            list2.addAll(new ArrayList<>(list));
        }

        solve(root.left, p, q, list1, list2, list);

        solve(root.right, p, q, list1, list2, list);

        list.remove(list.size() - 1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();

        solve(root, p, q, list1, list2, list);

        // traverse
        for (int i = list1.size() - 1; i >= 0; i--) {
            TreeNode val = list1.get(i);
            for (int j = list2.size() - 1; j >= 0; j--) {
                if (val == list2.get(j)) {
                    return val;
                }
            }
        }
        return root;
    }
}
